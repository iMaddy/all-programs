package com.maddy.algorithms.backtracking;

/**
 * Created by gitanjali on 26/02/17.
 */
public class StringPermutations
{
    public static void stringPermutations(char[] array, int l, int r)
    {
        if (l == r)
            System.out.println(String.valueOf(array));

        else
        {
            for (int i = l; i <= r; i++)
            {
                StringPermutations.swap(array, l, i);
                StringPermutations.stringPermutations(array, l + 1, r);
                StringPermutations.swap(array, i, l); //backtrack
            }
        }
    }

    public static void swap(char[] array, int i, int j)
    {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void interLeavingOfStrings(String str1, String str2, String result, int l1, int l2)
    {
        if (result.length() == str1.length() + str2.length())
            System.out.println(result);

        if (l1 < str1.length())
        {
            String temp = result + str1.charAt(l1);
            interLeavingOfStrings(str1, str2, temp, l1 + 1, l2);
        }

        if (l2 < str2.length())
        {
            String temp = result + str2.charAt(l2);
            interLeavingOfStrings(str1, str2, temp, l1, l2 + 1);
        }
    }

    public static void main(String[] args)
    {
//        String str = "abcabc";
//        StringPermutations.stringPermutations(str.toCharArray(), 0, str.length() - 1);

        String str1 = "ABC";
        String str2 = "PQR";
        String result = "";
       // StringPermutations.interLeavingOfStrings(str1, str2, result, 0, 0);
    }
}
