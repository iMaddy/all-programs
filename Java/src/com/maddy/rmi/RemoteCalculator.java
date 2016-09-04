package com.maddy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class RemoteCalculator extends UnicastRemoteObject implements IMathOperations
{
    private List<Record> records = new ArrayList<Record>();
    protected RemoteCalculator() throws RemoteException
    {

    }

    @Override
    public int add(int x, int y) throws RemoteException
    {
        System.out.println("Remote Add");
        int result = x+y;
        records.add(new Record(result, Record.Operation.ADD));
        return result;
    }

    @Override
    public int mutiply(int x, int y) throws RemoteException
    {
        System.out.println("Remote Multiply");
        int result = x*y;
        records.add(new Record(result, Record.Operation.MULTIPLY));
        return result;
    }

    @Override
    public List<Record> getOperationsHistory() throws RemoteException
    {
        return records;
    }
}
