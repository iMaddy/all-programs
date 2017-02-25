package com.maddy.algorithms.dp;

public class LongestCommonSubsequence
{

	public static int LCS(String str1, String str2)
	{
		//return LongestCommonSubsequence.lcsInternalRecursive(str1, str2, 0, 0);
		return LongestCommonSubsequence.lcsInternalDynamic(str1, str2);
	}
	
	/*
	 * recursive approach
	 * complexity of algorithms: time: O(2^n)
	 */
	private static int lcsInternalRecursive(String str1, String str2, int len1, int len2)
	{
		if(str1.length() == len1 || str2.length() == len2)
			return 0;
		
		if(str1.charAt(len1) == str2.charAt(len2))
			return 1 + LongestCommonSubsequence.lcsInternalRecursive(str1, str2, len1+1, len2+1);
		else
			return Math.max(
					LongestCommonSubsequence.lcsInternalRecursive(str1, str2, len1+1, len2), 
					LongestCommonSubsequence.lcsInternalRecursive(str1, str2, len1, len2+1)
					);
	}
	
	/*
	 * dynamic programming
	 * complexity: time: O(m*n) space: O(m*n)
	 */
	
	private static int lcsInternalDynamic(String str1, String str2)
	{
		int array[][] = new int[str1.length()+1][str2.length()+1];

		for(int i=1; i<=str1.length(); i++)
		{
			for(int j=1; j<=str2.length(); j++)
			{
				if(str1.charAt(i-1) == str2.charAt(j-1))
					array[i][j] = 1 + array[i-1][j-1];
				else
					array[i][j] = Math.max(array[i][j-1], array[i-1][j]);
			}
		}
		return array[str1.length()][str2.length()];
	}
};
