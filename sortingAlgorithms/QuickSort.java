package com.onkar;

public class QuickSort {
    public static int partion(int arr[], int low, int high) {
        int pivot = high;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;
        return i;
    }
    public static void quickSort(int arr [], int low, int high){
        if(low<high){
            int pidx = partion(arr,low,high);
            quickSort(arr,low,pidx-1);
            quickSort(arr,pidx+1,high);
        }
    }
    public static void main(String[] args) {
        int arr [] = {2,6,4,6,3,6,8};
        int n = arr.length;
        quickSort(arr,0, n-1);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
