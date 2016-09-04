package com.maddy.rmi;

import com.maddy.rmi.IMathOperations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class RemoteCalculator extends UnicastRemoteObject implements IMathOperations
{

    protected RemoteCalculator() throws RemoteException
    {
    }

    @Override
    public int add(int x, int y) throws RemoteException
    {
        System.out.println("Remote Add");
        return x+y;
    }

    @Override
    public int subtract(int x, int y) throws RemoteException
    {
        return x-y;
    }

    @Override
    public int mutiple(int x, int y) throws RemoteException
    {
        return x*y;
    }

    @Override
    public float divison(int x, int y) throws RemoteException
    {
        return (float)x/(float)y;
    }
}
