package com.onkar;

/**
 * find the number of ways in which you can invite n people to the party, single or in pair.
 */

public class Recursion {
    public static int pairFriends(int n) {
        if(n <= 1) {
            return 1;
        }

        int x = pairFriends(n-1) ;
        int y = (n-1) * pairFriends(n-2);
        return x+y;
    }

    public static void main(String ars[]) {
        int n = 4;
        System.out.println(pairFriends(n));
    }
}

