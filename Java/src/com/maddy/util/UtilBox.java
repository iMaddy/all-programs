package com.maddy.util;

import java.util.ArrayList;

/**
 * Created by gitanjali on 31/01/17.
 */
public class UtilBox
{
    /*
     * returns index of element in array, if element doesn't exist returns 1
     */
    public static int find(ArrayList<Integer> array, int key)
    {
        if(array != null)
        {
            for(int i=0; i<array.size(); i++)
            {
                if(array.get(i) == key)
                    return i;
            }
        }

        return -1;
    }
}
