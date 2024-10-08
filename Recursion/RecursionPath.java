package com.dsa.problem;

/**
 *
 * @finding total no of paths using recursion and dynamic programming
 */
public class RecursionPath {
    public static int countPaths(int i, int j, int m, int n,int mat[][]) {
        if(i == m-1 || j == n-1) {
            return 1;
        }
        if(mat[i][j] != -1){
            return mat[i][j];
        }

        int x = countPaths(i+1, j, m, n,mat);
        int y = countPaths(i, j+1, m, n,mat);
        mat[i][j] = x + y;
        return x + y;
    }

    public static void main(String args[]) {
        int m = 3, n = 3;
        int mat[][] = new int[m][n];
        mat[0][0] = -1;
        mat[0][1] = -1;
        mat[0][2] = -1;
        mat[1][0] = -1;
        mat[1][1] = -1;
        mat[1][2] = -1;
        mat[2][0] = -1;
        mat[2][1] = -1;
        mat[2][2] = -1;
        System.out.println(countPaths(0, 0, m, n,mat));
    }
}
// time complexity O(m * n)

