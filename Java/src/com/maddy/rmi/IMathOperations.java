package com.maddy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by madhukar.b on 04/09/16.
 */
public interface IMathOperations extends Remote
{
    public int add(int x, int y) throws RemoteException;

    public int subtract(int x, int y) throws RemoteException;

    public int mutiple(int x, int y) throws RemoteException;

    public float divison(int x, int y) throws RemoteException;
}
