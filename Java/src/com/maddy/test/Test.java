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
        int[] array = new int[]{-112, 1, 2, 3, 5};
        try
        {
            Sort.countingSort(array, 100);
        } catch (InvalidInputException e)
        {
            e.printStackTrace();
        }

        UtilBox.printArray(array);
    }
}
