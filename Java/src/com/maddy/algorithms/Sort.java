package com.maddy.algorithms;

import com.maddy.exceptions.InvalidInputException;
import com.maddy.util.UtilBox;

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

        for(int j=0; j<=end; j++)
        {
            if(array[j]< pivot)
            {
                int temp = array[j];
                array[j] = array[pivotIndex];
                array[pivotIndex]=temp;
                pivotIndex++;
            }
        }
        array[end] = array[pivotIndex];
        array[pivotIndex] = pivot;
        return pivotIndex;
    }

    public static void insertionSort(int[] array)
    {
        for(int i=0; i<array.length; i++)
        {
            int currentElement = array[i];
            int j=i;

            while (j>0 && array[j-1] > currentElement)
            {
                array[j] = array[j-1];
                j--;
            }
            array[j] = currentElement;
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

        //place the element at position by referring element count
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

    private static void countSortWithRadix(int[] array, int exp) throws InvalidInputException
    {
        int[] count = new int[10];

        //count occurrences and save in hash with index as element value

        for (int item: array)
        {
            if(item < 0)
                throw new InvalidInputException("Error: Invalid input: " + item);
            int digit = getDigit(item,exp);
            count[digit]++;
        }

        //cumulative sum
        for(int i=1; i<10; i++)
        {
            count[i] += count[i-1];
        }

        int temp[] = new int[array.length];

        for(int i=array.length-1; i>=0; i--)
        {
            int digit = getDigit(array[i], exp);
            temp[count[digit]-1] = array[i];
            count[digit]--;
        }

        for(int i=0; i<array.length; i++)
        {
            array[i] = temp[i];
        }
    }

    private static int getDigit(int item, int exp)
    {
        return (item/exp)%10;
    }
    public static void radixSort(int[] array) throws InvalidInputException
    {
        if(array.length<1)
            return;

        int max = UtilBox.getMax(array);

        for(int exp =1; (max/exp) >0; exp *= 10)
            countSortWithRadix(array,exp);

    }
}
