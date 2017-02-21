package com.maddy.collections.graph;

/**
 * Created by gitanjali on 21/02/17.
 */
public enum Color
{
    WHITE(0), GRAY(1), BLACK(2);

    private int color;

    public int getColor()
    {
        return color;
    }
    Color(int c)
    {
        color = c;
    }
}
