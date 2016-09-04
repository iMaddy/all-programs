package com.maddy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class RmiServer
{
    public static void main(String[] args) throws RemoteException, MalformedURLException
    {
//        IMathOperations stub = (IMathOperations) UnicastRemoteObject.exportObject(new RemoteCalculator(), 0);
        IMathOperations stub = (IMathOperations) new RemoteCalculator();
        LocateRegistry.createRegistry(1098);
        System.out.println("java RMI registry created.");
        Naming.rebind("rmi://localhost:1098/remoteservice", stub);
        System.out.println("remote server started...");
    }
}
