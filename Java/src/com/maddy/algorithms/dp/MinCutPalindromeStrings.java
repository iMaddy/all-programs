package com.maddy.algorithms.dp;

/**
 * Created by gitanjali on 16/03/17.
 */
public class MinCutPalindromeStrings
{
    public static void minCutPalindromeStrings(String str)
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
        int l = n;

        while(l>0)
        {
            for(int i=0; i<n-l+1; i++)
            {
                int j=i+l-1;
            }
        }
    }
}
