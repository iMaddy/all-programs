package com.maddy.algorithms.dp;

import com.maddy.util.UtilBox;

import java.util.Scanner;

/**
 * Created by gitanjali on 09/03/17.
 */
public class LongestCommonSubstring
{
    public static void longestCommonSubstring(String str1, String str2)
    {
        int len1 = str1.length();
        int len2 = str2.length();
        int T[][] = new int[len1+1][len2+1];
        int maxLen = 0;
        int indexI = 0;

        for(int i=1; i<=len1; i++)
        {
            for(int j=1; j<=len2; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    T[i][j] = 1 + T[i-1][j-1];
                    if(maxLen < T[i][j])
                    {
                        maxLen = T[i][j];
                        indexI = i-1;
                    }
                }
                else
                {
                    T[i][j] = 0;
                }
            }
        }

        if(maxLen != 0)
        {
            System.out.println(maxLen);
            System.out.println(str1.substring(indexI-maxLen+1,indexI+1));
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        longestCommonSubstring(sc.next(),sc.next());
    }
}
