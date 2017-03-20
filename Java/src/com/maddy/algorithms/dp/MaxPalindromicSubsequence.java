package com.maddy.algorithms.dp;

/**
 * Created by gitanjali on 15/03/17.
 */
public class MaxPalindromicSubsequence
{
    public static void maxPalindromSubstring(String str)
    {
        int n = str.length();

        int C[][] = new int[n][n];
        for(int i=0; i<n; i++)
        {
            C[i][i] = 1;
        }

        for(int l=2; l<=n; l++)
        {
            for(int i=0; i<n-l+1; i++)
            {
                int j = i+l-1;
                if(str.charAt(i) == str.charAt(j) && l==2)
                    C[i][j] = 2;
                else if(str.charAt(i) == str.charAt(j))
                    C[i][j] = 2 + C[i+1][j-1];
                else
                {
                    C[i][j] = Math.max(C[i+1][j],C[i][j-1]);
                }
            }
        }
        System.out.println(C[0][n-1]);
    }


    public static int max(int i, int j, int k)
    {
        return Math.max(Math.max(i,j),k);
    }

    public static void main(String[] args)
    {
        String str = "abcdabxdcbpq";

        maxPalindromSubstring(str);
    }
}
