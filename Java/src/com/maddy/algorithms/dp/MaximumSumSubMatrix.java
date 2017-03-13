package com.maddy.algorithms.dp;

import com.maddy.algorithms.Sort;
import com.maddy.util.UtilBox;

/**
 * Created by gitanjali on 13/03/17.
 */

class MaxSumData
{
    int i;
    int j;
    int maxSum;

    public MaxSumData(int ii, int jj, int mm)
    {
        i=ii;
        j=jj;
        maxSum=mm;
    }
}

public class MaximumSumSubMatrix
{
    public static void maximumSumSubMatrix(int[][] M)
    {
        if(M == null)
            return;

        int rows = M.length;
        int cols = M[0].length;
        int maxSum = Integer.MIN_VALUE;
        int left=0, right=0, top=0, bottom=0;

        for(int leftCol=0; leftCol<cols; leftCol++)
        {
            int[] temp = new int[rows];

            for(int rightCol=leftCol; rightCol<cols; rightCol++)
            {
                for(int i=0; i<rows; i++)
                    temp[i] += M[i][rightCol];

                MaxSumData data = MaximumSumSubMatrix.maxSumSubarray(temp);

                if(maxSum < data.maxSum)
                {
                    maxSum = data.maxSum;
                    left = leftCol;
                    right = rightCol;
                    top = data.i;
                    bottom = data.j;
                }
            }
        }

        System.out.println(maxSum);
        for(int i=top; i<=bottom; i++)
        {
            for(int j=left; j<=right; j++)
            {
                System.out.print(M[i][j]+ " ");
            }

            System.out.println();
        }
    }

    public static MaxSumData maxSumSubarray(int[] array)
    {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int currentI=0, i =0, j =0;

        for(int k=0; k<array.length; k++)
        {
            currentSum += array[k];
            if(maxSum < currentSum)
            {
                maxSum = currentSum;
                i = currentI;
                j = k;
            }

            if(currentSum<=0)
            {
                currentSum = 0;
                currentI = k+1;
            }
        }

        return new MaxSumData(i,j,maxSum);
    }


    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        {1,2,5,-3,-1},
                        {-3,-3,1,1,1},
                        {3,4,5,6,9,1},
                        {-1,5,8,1,9,4},
                        {1,4,-4,1,3}
                };

        UtilBox.printMatrix(matrix);
        MaximumSumSubMatrix.maximumSumSubMatrix(matrix);
    }
}
