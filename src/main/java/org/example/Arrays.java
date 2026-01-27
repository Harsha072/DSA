package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                char topElement = stack.remove(stack.size() - 1);
                if(topElement!=map.get(c)){
                    return  false;
                }
            }
            else{
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    public static int removeduplcateInPlace(int [] nums){
        int k = 0;


        for (int i = 0; i < nums.length; i++) {
            if(nums[k]!=nums[i]){
                nums[k+1] = nums[i];
                k++;
            }

        }
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
        return k;
    }

    public static void mergeTwoSortedArray(int [] nums1, int [] nums2) {
        int k = nums1.length - 1;

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (nums1[k] != nums2[i]) {
                nums1[k] = nums2[i];
                k--;
            }
        }
        for (int j = 0; j < nums1.length; j++) {
            System.out.println(nums1[j]);
        }
    }

    public static void moveZerosToEnd(int [] nums1) {
        int i=0;
        int j = 0;

        while(j<= nums1.length-1){
            if(nums1[j]!=0){
                int temp = nums1[j];
                nums1[j] = nums1[i];
                nums1[i] = temp;
                i++;
            }
             j++;
        }

        for (int k = 0; k <nums1.length ; k++) {
            System.out.println(nums1[k]);
        }
    }
    public static void sumOfAll(int [] nums1) {
        int [] results = new int[nums1.length];

        int sum = 0;
        for (int i = 0; i <nums1.length ; i++) {
           sum = sum+nums1[i];
           results[i] = sum;

        }

        for (int k = 0; k <results.length ; k++) {
            System.out.println(results[k]);
        }
    }
    public static int findNumbers(int[] nums) {
        int count = 0; // Count of numbers with even digits

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitCount = 0; // Count digits for this number

            // Keep dividing by 10 until num becomes 0
            while (num > 0) {
               num = num/10;
                // Increment digitCount
                digitCount++;
            }

            if(digitCount%2==0){
                count++;
            }
            // Check if digitCount is even
            // If yes, increment count
        }

        System.out.println(count);
        return count;
    }
    public static int consequtiveOnes(int[] nums) {
        int count = 0; // Count of numbers with even digits

        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==1){
                count++;
            }
            else count = 0;
        }
        System.out.println(count);
        return count;
    }
    public static void disappeared(int[] nums) {
        HashSet set = new HashSet();
        ArrayList list = new ArrayList();
        for (int i : nums){
            set.add(i);
        }

        for (int i = 1; i <8 ; i++) {
            if(!set.contains(i)){
                list.add(i);
            }
        }

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;  // Found a duplicate!
            }
            set.add(nums[i]);
        }

        return false;
    }

    public static boolean isAnagram(String s, String t) {
         int [] freq = new int[26];

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            int index  = c - 'a';
            freq[index]++;
        }
System.out.println("before sub s ");
        for (int j : freq) {
            System.out.println(j);
        }


        for (int i = 0; i <t.length() ; i++) {
            char c = t.charAt(i);
            int index  = c - 'a';
            freq[index]--;
        }

        System.out.println("after sub s ");
        for (int j : freq) {
            System.out.println(j);
        }

        for (int j : freq) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }





    public static void main(String[] args) {
    int [] myArr = {0, 0, 1, 2, 2, 2, 3, 4};
        int val = 2;
        int [] num1 = {1,1,1,3,3,4,3,2,4,2};
        int [] nums2 = {1,1,0,1,1,1};

//    deletingFromEnd(myArr);
        //insertAtEnd(myArr, 9, 2, 4 );
//        insertAtithIndex(myArr, 5, 2);
      // int k = removeAllOccurances(myArr,val);
//        System.out.print("First k elements: ");

       // int []  s =getConcatenation(myArr);
//        for (int i = 0; i <s.length ; i++) {
//            System.out.println(s[i]);
//        }
        //System.out.println(removeduplcateInPlace(myArr));
        //mergeTwoSortedArray(num1, nums2);
       // moveZerosToEnd(num1);

       // findNumbers(num1);
        //consequtiveOnes(nums2);
      //  disappeared(num1);
        containsDuplicate(num1);

      System.out.println(isAnagram("carrace", "racecar"));

    }
}
