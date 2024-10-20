package com.onkar;

import java.util.HashSet;
import java.util.Set;

public class HashMapProblem1 {

    // Union of a array.
    // Time complexity O(n).
    public static int union(int arr1[],int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for (int j=0;j<arr2.length;j++){
            set.add(arr2[j]);
        }
        return set.size();
    }

    // Intersection of a two arrays.
    // time comeplexity O(n).
    public static int intersection(int [] arr1,int [] arr2){

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int count = 0;
        for(int j=0;j<arr2.length;j++){
            if(set.contains(arr2[j])){
                count++;
                set.remove(arr2[j]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println(union(arr1,arr2));
        System.out.println(intersection(arr1,arr2));
    }
}
