package com.maddy.test;

import com.maddy.algorithms.Sort;
import com.maddy.exceptions.InvalidInputException;
import com.maddy.util.UtilBox;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class Test
{
    public static void main(String[] args)
    {
        int[] array = new int[]{12222, 12, 21, 334, 736635, 1, 212, 1221, 13456};
        try
        {
            Sort.radixSort(array);
        } catch (InvalidInputException e)
        {
            e.printStackTrace();
        }

        UtilBox.printArray(array);
    }
}
