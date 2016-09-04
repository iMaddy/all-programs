package com.maddy.rmi;

import java.io.Serializable;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class Record implements Serializable
{
    public enum Operation {ADD, MULTIPLY}
    private int result;
    private Operation operation;

    Record(int v, Operation op)
    {
        this.result = v;
        this.operation = op;
    }

    public void printRecord()
    {
        System.out.println("Operation: " + operation + " Result: " + result);
    }
}
