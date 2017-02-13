package com.maddy.systemdesign.callcenter;

import com.maddy.systemdesign.callcenter.util.EmployeeIdGenerator;

/**
 * Created by gitanjali on 13/02/17.
 */
public class Respondent extends Employee
{
    public Respondent()
    {
        super(EmployeeIdGenerator.getNextEmployeeId());
        rank = Rank.Respondent;
    }
}
