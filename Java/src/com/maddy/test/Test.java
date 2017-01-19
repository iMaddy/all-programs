package com.maddy.test;

import com.maddy.algorithm.LongestIncreasingSubsequence;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class Test
{
    public static void main(String[] args)
    {
    	int array[] = {5, -1, 3, 1, 3, 2, 7, 8, 2, 22, 1, -13, 1, 5, 8};
    	int n = LongestIncreasingSubsequence.longestIncreasingSubsequence(array);
    	System.out.println(n);
    }
}
