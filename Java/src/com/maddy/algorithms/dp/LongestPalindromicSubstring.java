package com.maddy.algorithms.dp;

import java.util.Scanner;

/**
 * Created by gitanjali on 09/03/17.
 */
public class LongestPalindromicSubstring
{
    // --- brute force approach
    /*
        Time complexity O(n^3)
     */
    public static void longestPalindromicSubstringBruteForce(String str1)
    {
        int n = str1.length();
        String result = null;
        for(int l=2; l<=n; l++)
        {
            for(int i=0; i<n-l+1; i++)
            {
                int temp = i;
                int j = i+l-1;
                while(i<j)
                {
                    if(str1.charAt(i) != str1.charAt(j))
                    {
                        break;
                    }

                    i++;
                    j--;
                }

                if(i>=j)
                {
                  result = str1.substring(temp,temp+l);
                  break;
                }
            }
        }

        System.out.println(result);
    }

    // efficient solution will be implemented later on

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LongestPalindromicSubstring.longestPalindromicSubstringBruteForce(sc.next());
    }
}
