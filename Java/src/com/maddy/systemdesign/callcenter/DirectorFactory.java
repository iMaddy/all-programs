package com.maddy.systemdesign.callcenter;

/**
 * Created by gitanjali on 13/02/17.
 */
public class DirectorFactory extends AbstractFactory
{
    @Override
    public CallAttendant createEmployee()
    {
        return new Director();
    }
}
