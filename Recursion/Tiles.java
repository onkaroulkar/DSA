package com.dsa.problem;

/**
 * place a tile of 1 * m in a floor of size n * m
 */
public class Tiles {
    public static int placeTiles(int n, int m) {
        if(n < m) {
            return 1;
        } else if(n == m) {
            return 2;
        }
        int x = placeTiles(n-1, m);
        int y = placeTiles(n-m, m);
        return x + y;
    }

    public static void main(String args[]) {
        int n = 4, m = 2;
        System.out.println(placeTiles(n, m));
    }
}

// time complexity = O(2^n*m)----need to see mathematical calculation.
