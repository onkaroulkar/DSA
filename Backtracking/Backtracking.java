package com.onkar;

/**
 * All possible arrangements of a string ABC
 */

public class Backtracking {
    public static void printPermutation(String str, int idx, String perm) {
        if(str.length() == 0) {
            System.out.println(perm);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            String prem = perm+currChar;
            printPermutation(newStr, idx+1, prem);
        }
    }
    public static void main(String args[]) {
        String str = "abc";
        printPermutation(str, 0, "");
    }
}

// time complexity = O(n * n!)
