package com.maddy.test;

import com.maddy.algorithm.LongestCommonSubsequence;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class Test
{
    public static void main(String[] args)
    {
    	String str1 = "abcbcab";
    	String str2 = "abab";
    	System.out.println(str1 + " " + str2+ " " + LongestCommonSubsequence.LCS(str1, str2));
    }
}
