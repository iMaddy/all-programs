package com.maddy.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gitanjali on 11/02/17.
 */
public class Solution
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int in;

        ArrayList<Integer> a = new ArrayList<>();
        while ((in = sc.nextInt()) != -1)
        {
            a.add(in);
        }

        System.out.println(Solution.plusOne(a));
    }

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y)
    {
        int x1 = 0;
        int y1 = 0;
        int sum = 0;
        for(int i=0; i<X.size(); i++)
        {
            int x2 = X.get(i);
            int y2 = Y.get(i);
            sum += Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
            x1 = x2;
            y1 = y2;
        }
        return sum;
    }


    public static ArrayList<Integer> plusOne(ArrayList<Integer> a)
    {
        int max = a.size();
        ArrayList<Integer> array = new ArrayList<>(max+1);
        for(int i=0; i<max+1; i++)
        {
            array.add(0);
        }
        int reminder = 0;
        int sum;
        int index = max-1;
        int plusOne = 1;
        while(index >= 0)
        {
            sum = (a.get(index) + reminder + plusOne) % 10;
            reminder = (a.get(index) + reminder + plusOne) / 10;
            array.set(index+1,sum);
            index--;
            plusOne = 0;
        }
        array.set(0, reminder);
        int i;
        for(i=0; i<array.size(); i++)
        {
            if(array.get(i) != 0)
                break;
        }
         array = null;
        return new ArrayList(array.subList(i,max+1));
    }
}
