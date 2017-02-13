package com.maddy.systemdesign.callcenter;

import com.maddy.systemdesign.callcenter.util.EmployeeIdGenerator;

/**
 * Created by gitanjali on 13/02/17.
 */
public class Manager extends Employee
{
    public Manager()
    {
        super(EmployeeIdGenerator.getNextEmployeeId());
        rank = Rank.Manager;
    }
}
