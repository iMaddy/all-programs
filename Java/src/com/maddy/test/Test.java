package com.maddy.test;

import com.maddy.algorithm.ArraySubsetSumNonNegative;
import com.maddy.util.UtilBox;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class Test
{
    public static void main(String[] args)
    {
        boolean isPresent = ArraySubsetSumNonNegative.isSubsetWithSumPresent(UtilBox.arrayListToArray(), 10);
        System.out.println(isPresent);
    }
}
