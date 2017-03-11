package com.maddy.algorithms.dp;

/**
 * Created by gitanjali on 09/03/17.
 */

class PositionDetails
{
    public int length;
    public int i;
    public int j;
}

public class MaximumFilledBooleanMatrix
{
    public static void maxFilledMatrix(int[][] M)
    {
        if (M == null)
            return;

        int row = M.length;
        int column = M[0].length;

        int up[][] = new int[row][column];
        int left[][] = new int[row][column];

        if (M[0][0] == 1)
        {
            up[0][0] = 1;
            left[0][0] = 1;
        }

        PositionDetails pd = new PositionDetails();
        // 1st row
        for (int j = 1; j < column; j++)
        {
            if(M[0][j] == 1)
            {
                up[0][j] = 1;
                left[0][j] =1 + left[0][j-1];
                pd.length = 1;
                pd.i = 0;
                pd.j = j;
            }
        }

        // 1st column
        for (int i = 1; i < row; i++)
        {
            if(M[i][0] == 1)
            {
                left[i][0] = 1;
                up[i][0] =1 + up[i-1][0];
                pd.length = 1;
                pd.i = i;
                pd.j = 0;
            }
        }

        for(int i=1; i<row; i++)
        {
            for(int j=1; j<column; j++)
            {
                if(M[i][j] == 1)
                {
                    up[i][j] = 1 + Math.min(up[i-1][j-1],up[i-1][j]);
                    left[i][j] = 1 + Math.min(left[i][j-1], left[i-1][j-1]);

                    int maxLength = Math.min(up[i][j], left[i][j]);

                    if(maxLength > pd.length)
                    {
                        pd.length = maxLength;
                        pd.i = i;
                        pd.j = j;
                    }
                }
            }
        }
        MaximumFilledBooleanMatrix.printMatrix(M);
        MaximumFilledBooleanMatrix.printMatrix(up,left);
        System.out.println(pd.i + "," + pd.j + "=> " + pd.length);
    }

    public static void printMatrix(int[][] A)
    {
        if(A==null)
            return;

        for(int i=0; i<A.length; i++)
        {
            for(int j=0; j<A[0].length; j++)
                System.out.print(A[i][j]+ "       ");

            System.out.println();
        }

        System.out.println();
    }

    public static void printMatrix(int[][] A, int[][] B)
    {
        if(A==null)
            return;

        for(int i=0; i<A.length; i++)
        {
            for(int j=0; j<A[0].length; j++)
                System.out.print(A[i][j]+","+B[i][j]+ "     ");

            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[][] M =
                {
                        {0,0,0,1,0,0},
                        {0,0,0,1,1,0},
                        {0,1,1,1,1,1},
                        {0,0,1,1,1,1},
                        {1,1,1,1,1,1},
                        {1,1,1,1,1,0},
                        {0,0,0,1,0,0}
                };

        MaximumFilledBooleanMatrix.maxFilledMatrix(M);
    }
}
