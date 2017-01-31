package com.maddy.util;

public class WrapInt
{
	private int n;
	
	public WrapInt(int num)
    {
        n = num;
    }

    public int get()
    {
        return n;
    }

    public int getValueAndDecreament()
    {
        int r = n;
        n--;
        return r;
    }
}
