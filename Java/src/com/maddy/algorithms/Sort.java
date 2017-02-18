package com.maddy.algorithms;

import com.maddy.exceptions.InvalidInputException;

/**
 * Created by madhukar.b on 24/12/16.
 */
public class Sort
{
    public static void quickSort(int[] array)
    {
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array, int beg, int end)
    {
        if(beg<end)
        {
            int pivot = partition(array,beg,end);
            quickSort(array,beg,pivot-1);
            quickSort(array,pivot+1,end);
        }
    }

    private static int partition(int[] array, int beg, int end)
    {
        int pivot = array[end];
        int pivotIndex = beg;
        int currentIndex = beg;

        while(currentIndex<end)
        {
            if(array[currentIndex]< pivot)
            {
                int temp = array[currentIndex];
                array[currentIndex] = array[pivotIndex];
                array[pivotIndex]=temp;
                pivotIndex++;
            }
            currentIndex++;
        }
        array[end] = array[pivotIndex];
        array[pivotIndex] = pivot;
        return pivotIndex;
    }

    public static void insertionSort(int[] array)
    {
        for(int i=0; i<array.length; i++)
        {
            int element = array[i];
            int j=i;

            while (j>0 && array[j-1] > element)
            {
                array[j] = array[j-1];
                j--;
            }
            array[j] = element;
        }
    }

    public static void countingSort(int[] array, int range) throws InvalidInputException
    {
        int[] count = new int[range+1];

        //count occurrences and save in hash with index as element value

        for (int item: array)
        {
            if(item>range || item < 0)
                throw new InvalidInputException("Error: Invalid input: " + item);

            count[item]++;
        }

        //place the element at position by refering element count
        int k = 0;
        for(int i=0; i<=range; i++)
        {
            if(count[i] != 0)
            {
                while(count[i]-- > 0)
                {
                    array[k++] = i;
                }
            }
        }
    }
}
