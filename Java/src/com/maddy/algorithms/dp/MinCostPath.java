package com.maddy.algorithms.dp;

/**
 * Created by gitanjali on 27/02/17.
 */
public class MinCostPath
{
    public static void shortestPath(int[][] matrix, int r, int c)
    {
        if(r<1 || c<1)
            return;

        int[][] distance = new int[r][c];
        distance[0][0] = matrix[0][0]; //base case

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int topLeft = Integer.MAX_VALUE;

        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                up = Integer.MAX_VALUE;
                left = Integer.MAX_VALUE;
                topLeft = Integer.MAX_VALUE;

                if(i-1 >=0)
                    up = distance[i-1][j];

                if(j-1 >=0)
                    left = distance[i][j-1];

                if(i-1>=0 && j-1>=0)
                    topLeft = distance[i-1][j-1];

                int min = min(up, left, topLeft);

                if(min == Integer.MAX_VALUE) //edge case for matrix[0][0]
                    min = 0;

                distance[i][j] = matrix[i][j] + min;

            }
        }

        System.out.println(distance[r-1][c-1]);
    }

    public static int min(int i, int j, int k)
    {
        return Math.min(Math.min(i,j), k);
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,2,3},
                {4,-1,2},
                {1,5,3}
        };

        MinCostPath.shortestPath(matrix, matrix.length, matrix[0].length);
    }
}
