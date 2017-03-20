package com.maddy.algorithms.dp;

import com.maddy.util.UtilBox;

/**
 * Created by madhukar on 14/03/17.
 */
public class MaxNonPalindromSubstring
{
    /*
        time complexity: O(n^2), space complexity: O(n^2)
     */
    public static void maxNonPalindromSubstring(String str)
    {
        int n = str.length();

        int C[][] = new int[n][n];

        for(int l=2; l<=n; l++)
        {
            for(int i=0; i<n-l+1; i++)
            {
                int j = i+l-1;

                if(str.charAt(i) != str.charAt(j))
                    C[i][j] = j-i+1;
                else
                {
                    C[i][j] = max( C[i+1][j], C[i][j-1], 2+C[i+1][j-1]);
                }

                int breakpoint =0;
            }
        }
//        for(int i=0; i<n; i++)
//            System.out.print(i + " ");
//        System.out.println();
//        UtilBox.printMatrix(C);

        System.out.println(C[0][n-1]);
    }

    public static int maxPalRecursive(String str, int i, int j)
    {
        if(str == null)
            return -1;
        if(i>j) //they crossed so return -2
            return -2;

        if(i==j)
            return 0;

        if(str.charAt(i) != str.charAt(j))
        {
            return j-i+1;
        }

        return max(maxPalRecursive(str,i+1,j),
                maxPalRecursive(str,i,j-1), 2+maxPalRecursive(str,i+1,j-1));
    }

    public static int max(int i, int j, int k)
    {
        return Math.max(Math.max(i,j),k);
    }

    public static void main(String[] args)
    {
        String str = "bbaaaaaaaaabb";

        maxNonPalindromSubstring(str);

        System.out.println(maxPalRecursive(str,0,str.length()-1));
    }
}
