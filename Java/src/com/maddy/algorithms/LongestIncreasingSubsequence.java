package com.maddy.algorithms;

public class LongestIncreasingSubsequence
{
	/*
	 * Algorithm complexity: time O(n^2), space O(n)
	 */
	public static int longestIncreasingSequence(int []input)
	{
		int length = input.length;
		int array[] = new int[length];
		int actualArray[] = new int[length];
		for(int i=0; i<length; i++)
		{
			array[i] = 1;
			actualArray[i] = i;
		}
		
		for(int i=0; i<length; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(input[j] < input[i])
				{
					array[i] = Math.max(array[i], array[j] + 1);
					actualArray[i] = j;
				}
			}
		}

		int maxIndex = 0;
		for(int i=0; i<length; i++)
		{
			if(array[i] > array[maxIndex])
				maxIndex = i;
		}


        //lets print the actual solution - printed in reverse order
		LongestIncreasingSubsequence.printLIS(input, actualArray, maxIndex);
		System.out.println();
		return array[maxIndex];
	}
	
	private static void printLIS(int input[], int actualArray[], int t)
	{
		if(actualArray[t] == t)
		{
			System.out.print(input[t]+ " ");
			return;
		}
		printLIS(input, actualArray, actualArray[t]);
		System.out.print(input[t] + " ");
	}
}
