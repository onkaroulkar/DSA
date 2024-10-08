package com.onkar;
import java.util.ArrayList;
/**
 * print all the subsets of the set of a first n natural numbers.
 */
public class Recursion1 {
    public static void printSubsets(ArrayList<Integer> subset) {
        for(int i=0; i<subset.size(); i++) {
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void findSubsets(int n, ArrayList<Integer> subset) {
        if(n == 0) {
            printSubsets(subset);
            return;
        }

        findSubsets(n-1, subset);
        subset.add(n);
        findSubsets(n-1, subset);
        subset.remove(subset.size() - 1);
    }

    public static void main(String args[]) {
        int n = 2;
        findSubsets(n, new ArrayList<Integer> ());
    }
}
// time complexity = O(2^n)
