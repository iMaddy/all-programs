package com.maddy.algorithms;

import java.util.Arrays;
import java.util.List;

public class Number {

	public static boolean isPrime(int n)
	{
		if(n<=1) return false;
		if(n==2) return true;
		if(n%2==0) return false;
		int m = (int)Math.sqrt(n);
		
		for(int i=3; i<=m; i+=2)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	/*
	 *  complexity of algorithms: O(n*log log n)
	 */
	public static List<Integer> primeNumberUpto(int n)
	{
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		int m = (int) Math.sqrt(n);
		
		for(int i=2; i<m; i++)
		{
			if(prime[i])
			{
				for(int k=i*i; k<=n; k+=i)
				{
					prime[k] = false;
				}
			}
		}
		
		List<Integer> list = new java.util.LinkedList<>();
		
		for(int i=0; i<n; i++)
		{
			if(prime[i])
				list.add(i);
		}
		
		return list;
	}

	/*
	 * complexity of algorithms: log(b)
	 */
	public static int GCD(int a, int b)
	{
		if(b==0)
			return a;
		
		return GCD(b, a%b);
	}

	public static int LCM(int a, int b)
	{
		return (a*b)/Number.GCD(a, b);
	}
}
