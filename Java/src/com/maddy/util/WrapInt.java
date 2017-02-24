package com.maddy.util;

public class WrapInt
{
	private int n;
	
	public WrapInt(int num)
    {
        n = num;
    }

    public int getValue()
    {
        return n;
    }

    public void setValue(int n)
    {
        this.n = n;
    }

    public int getValueAndDecrement()
    {
        int r = n;
        n--;
        return r;
    }
}
