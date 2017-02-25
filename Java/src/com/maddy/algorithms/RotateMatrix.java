package com.maddy.algorithms;

/**
 * Created by gitanjali on 25/02/17.
 */
public class RotateMatrix
{
    //rotate matrix by 90* clockwise
    public static void rotateMatrix(int[][] matrix)
    {
        if(matrix.length < 2 || matrix.length != matrix[0].length) // not an square matrix return
            return;

        int l =0;
        int m =matrix.length-1;
        int p = 0;
        int q = matrix[0].length-1;

        while(l<m && p<q)
        {
            // just write to rotate by 1
            int rotationTime = q-p;
            while(rotationTime-- > 0)
            {
                rotateByOnePosition(matrix, l, m, p, q);
            }

            l++;
            m--;
            p++;
            q--;
        }
    }

    private static void rotateByOnePosition(int[][] matrix, int l, int m, int p, int q)
    {
        //rotate top row
        int prev = matrix[l][p];
        int current;
        for(int i=p+1; i<=q; i++)
        {
            current = matrix[l][i];
            matrix[l][i] = prev;
            prev = current;
        }
        //rotate last column
        for(int i=l+1; i<=m; i++)
        {
            current = matrix[i][q];
            matrix[i][q] = prev;
            prev = current;
        }

        //rotate bottom row
        for(int i=q-1; i>=p; i--)
        {
            current = matrix[m][i];
            matrix[m][i] = prev;
            prev = current;
        }

        // rotate first column
        for(int i=m-1; i>=l; i--)
        {
            current = matrix[i][p];
            matrix[i][p] = prev;
            prev = current;
        }
    }

    public static void printMatrix(int[][] matrix)
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int [ ] [ ] scores =
                {
                { 20, 21, 22, 23},
                { 31, 32, 33, 24},
                { 30, 35, 34, 25},
                { 29, 28, 27, 26 }
                };

        RotateMatrix.printMatrix(scores);
        RotateMatrix.rotateMatrix(scores);
        RotateMatrix.printMatrix(scores);
    }
}
