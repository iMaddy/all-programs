package com.maddy.algorithm;

import java.util.ArrayList;

/**
 * Created by gitanjali on 13/02/17.
 */
public class ArraySubsetSumNonNegative
{
    public static boolean isSubsetWithSumPresent(int input[], int sum)
    {
        // logic: n - length of input
        // subset(input, n, sum) => subset(input, n-1, sum) OR subset(input, n-1, sum - input[n])

        // T[][] - temp matrix
        // row - represent element from input
        // column - subsum- 0,1,2,....,sum
        // T[i][j] = true if input[0] .... input [i] contains subset which has sum j
        boolean T[][] = new boolean[input.length][sum+1];

        //for each input array there will have null subset that sums to 0
        for(int i=0; i<input.length; i++)
        {
            T[i][0] = true;
        }

        //input[0] can only gives sum if input[0] == sum
        for(int j=1; j<=sum; j++)
        {
            if (input[0] == j)
                T[0][j] = true;
            else
                T[0][j] = false;
        }

        for(int i=1; i<input.length; i++)
        {
            for(int j = 1; j<=sum; j++)
            {
                T[i][j] = T[i-1][j]; // if true if previous subarray contains sum(j)

                if ( j-input[i] >= 0)
                {
                    // if subarray contains sum including current element
                    T[i][j] = T[i-1][j] || T[i-1][j-input[i]];
                }
            }
        }

        return T[input.length-1][sum];
    }
}
