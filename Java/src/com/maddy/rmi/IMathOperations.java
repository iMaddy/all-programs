package com.maddy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by madhukar.b on 04/09/16.
 */
public interface IMathOperations extends Remote
{
    public int add(int x, int y) throws RemoteException;

    public int mutiply(int x, int y) throws RemoteException;

    public List<Record> getOperationsHistory() throws RemoteException;
}
