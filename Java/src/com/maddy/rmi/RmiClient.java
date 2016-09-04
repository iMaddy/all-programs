package com.maddy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class RmiClient
{
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException
    {
        IMathOperations stub = (IMathOperations) Naming.lookup("rmi://localhost:1098/remoteservice");
        System.out.println("Add: " + stub.add(48, 22));
        System.out.println("Multiply: " + stub.mutiply(3, 22));
        System.out.println("Add: " + stub.add(43,21));
        for(Record r: stub.getOperationsHistory())
        {
            r.printRecord();
        }
    }
}
