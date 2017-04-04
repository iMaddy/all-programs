package com.maddy.algorithms.dp;

/**
 * Created by gitanjali on 16/03/17.
 */
public class MinCutPalindromeStrings
{
    public static int minCutPalindromeStrings(String str)
    {
        int n = str.length();
        boolean T[][] = new boolean[n][n];

        for(int i=0; i<n; i++)
            T[i][i] = true;

        for(int l=2; l<=n; l++)
        {
            for(int i=0; i<n-l+1; i++)
            {
                int j = i+l-1;

                if(str.charAt(i) == str.charAt(j) && l==2)
                    T[i][j] = true;
                else if(str.charAt(i) == str.charAt(j))
                    T[i][j] = T[i+1][j-1];
                else
                    T[i][j] = false;
            }
        }

        int[] C = new int[n];
        for (int i=0; i<n; i++)
        {
            if (T[0][i] == true)
                C[i] = 0;
            else
            {
                C[i] = Integer.MIN_VALUE;
                for(int j=0;j<i;j++)
                {
                    if(T[j+1][i] == true && 1+C[j]<C[i])
                        C[i]=1+C[j];
                }
            }
        }

        // Return the min cut value for complete string. i.e., str[0..n-1]
        return C[n-1];
    }
}
