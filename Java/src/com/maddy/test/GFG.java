package com.maddy.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gitanjali on 23/02/17.
 */
public class GFG
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
        {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++)
            {
                int num = sc.nextInt();
                array[i] = num * num;
            }
            if (foundTriplet(array))
                System.out.println("Yes");
            else
                System.out.println("No");

        }
    }

    public static boolean foundTriplet(int[] array)
    {
        if (array.length < 3)
            return false;
        Arrays.sort(array);

        for (int k = array.length - 1; k > 2; k--)
        {
            int sum = array[k];
            int i = 0;
            int j = k - 1;

            while (i < j)
            {
                if (array[i] + array[j] == sum)
                    return true;

                if (array[i] + array[j] > sum)
                    j--;
                else
                    i++;
            }
        }

        return false;

    }
}
