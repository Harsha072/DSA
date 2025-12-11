package org.example;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public static void read(int [] arr){
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void deletingFromEnd(int [] arr){

        int [] arr2 = new int[arr.length-1];
        for (int i = 0; i <arr2.length ; i++) {
            arr2[i] = arr[i];
        }
        for(int i=0;i< arr2.length;i++){
            System.out.println(arr2[i]);
        }

    }

    public static void deletingAtithIndex(int [] arr, int index){

      //check if index is less than length
        if(index>arr.length){
            return;
        }
        //soft deleting
        arr[index] = 0;
        //or
        for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
        }
            // Now use only first (size - 1) elements
    }

    public static void insertAtEnd(int [] arr, int n, int length, int capacity){
        if(length<capacity){
            arr[length+1] = n;
        }
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
//[1,2,3,0,0]
    public static void insertAtithIndex(int [] arr, int n, int index){
      //assuming array is not full
        for (int j = 0; j <=index ; j++) {
            if(j==index){
                arr[j+1] = arr[j];
                arr[j] = n;
            }

        }

        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static int removeAllOccurances(int [] arr, int val){
         int k = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=val){
                arr[k] = arr[i];
                k++;
            }
        }
        return k;

    }
    public static int[] getConcatenation(int[] nums) {
        int n = 2 *nums.length;
        int k = nums.length+1;
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int num : nums) {
            list.add(num);
        }
        for (int num : nums) {
            list.add(num);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
    int [] myArr = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
//    deletingFromEnd(myArr);
        //insertAtEnd(myArr, 9, 2, 4 );
//        insertAtithIndex(myArr, 5, 2);
       int k = removeAllOccurances(myArr,val);
        System.out.print("First k elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(myArr[i] + " ");
        }
        int []  s =getConcatenation(myArr);
        for (int i = 0; i <s.length ; i++) {
            System.out.println(s[i]);
        }

    }
}
