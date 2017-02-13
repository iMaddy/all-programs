package com.maddy.systemdesign.callcenter.util;

/**
 * Created by gitanjali on 13/02/17.
 */
public class EmployeeIdGenerator
{
    private static int empId = 1;

    synchronized public static int getNextEmployeeId()
    {
        return empId++;
    }
}
