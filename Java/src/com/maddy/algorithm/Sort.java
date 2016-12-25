package com.maddy.algorithm;

/**
 * Created by madhukar.b on 24/12/16.
 */
public class Sort
{
    public static void main(String []args)
    {
        int[] array = {2, -4, 5, 6, 2, 11, 45, 83, 9823, -8, -33, 34, 54};
//        quickSort(array);
        insertionSort(array);
        for(int item: array)
        {
            System.out.println(item);
        }
    }

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

}
