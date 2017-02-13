package com.maddy.systemdesign.callcenter;

/**
 * Created by gitanjali on 13/02/17.
 */
public enum Rank
{
    Respondent(0), Manager(1), Director(2);

    private int value;

    public int getValue()
    {
        return value;
    }

    private Rank(int v)
    {
        value = v;
    }
}
