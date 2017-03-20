package com.maddy.algorithms.matrix;

/**
 * Created by gitanjali on 20/03/17.
 */
public class MatrixPath
{
    static void printAllPathsUtil(int[][] mat, int i, int j, int m, int n, int[] path, int pi)
    {
        // Add the current cell to the path being generated
        path[pi] = mat[i][j];

        if (i == m - 1 && j == n - 1)
        {
            for (int l = 0; l <= pi; l++)
                System.out.print(path[l] + " ");
            System.out.println();
        }

        // Print all the paths that are possible after moving down
        if(i+1<m)
            printAllPathsUtil(mat, i + 1, j, m, n, path, pi + 1);

        // Print all the paths that are possible after moving right
        if(j+1<n)
            printAllPathsUtil(mat, i, j + 1, m, n, path, pi + 1);

        // Print all the paths that are possible after moving diagonal
        if(i+1<m && j+1<n)
         printAllPathsUtil(mat, i+1, j+1, m, n, path, pi + 1);
    }

    // The main function that prints all paths from top left to bottom right
// in a matrix 'mat' of size mXn
    public static void main(String[] args)
    {
        int mat[][] = {{1, 2, 3}, {4, 5, 6}};
        int m = mat.length;
        int n = mat[0].length;
        int[] path = new int[m + n];
        printAllPathsUtil(mat, 0, 0, m, n, path, 0);
    }
}
