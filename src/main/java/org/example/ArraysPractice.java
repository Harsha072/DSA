package org.example;

import java.util.*;

public class ArraysPractice {

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



    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")  || tokens[i].equals("-") || tokens[i].equals("*")|| tokens[i].equals( "/")){
                if(tokens[i].equals("+")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                    }
                if(tokens[i].equals("-")){
                    int a  =  stack.pop();
                    int b  =  stack.pop();

                    stack.push(b-a);

                }
                if(tokens[i].equals("*")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a*b);
                }
                if(tokens[i].equals("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }


            }

            else{
                int c = Integer.parseInt(tokens[i]);
                stack.push(c);
            }
        }

        return  stack.pop();
    }
    class MinStack {

        ArrayList<Integer> stack = null;
        ArrayList<Integer> minStack = null;

        public MinStack() {
            this.stack = new ArrayList<>();
            this.minStack = new ArrayList<>();
        }

        public void push(int val) {
            stack.add(val);
            if (minStack.isEmpty()) {
                minStack.add(val);
            } else {
                minStack.add(Math.min(val, minStack.get(minStack.size()-1)));
            }
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size()-1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size()-1);
        }
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
        return k+1;
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
        int [] freq= new int[26];

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            int index = c-'a';
            freq[index] = freq[index]+1;
        }
        for (int i = 0; i <freq.length ; i++) {
            System.out.println(freq[i]);
        }
        for (int i = 0; i <t.length() ; i++) {
            char c = t.charAt(i);
            int index = c-'a';
            freq[index]= freq[index]-1;
        }
        System.out.println("______________________________________________________________");
        for (int i = 0; i <freq.length ; i++) {
            System.out.println(freq[i]);
        }
         for(int j : freq){
             if (j!=0){
                 return false;
             }
         }
        return  true;
    }


    public static int [] revArray(int [] s) {

        int i = 0;
        int j = s.length-1;

        if(s.length>1){
            while (i<j){
                int temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }
        else return s;

        return s;
    }
    public static int [] rotateArray(int [] s) {
        int i = 0;
        int j = s.length-1;

        if(s.length>1){
            while (i<j){
                int temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }

        return s;
    }

    private static void rotateFirstHalf(int[] myArr2, int k) {
        int i = 0;
        int j = k-1;
        while (i<j){
            int temp = myArr2[i];
            myArr2[i] = myArr2[j];
            myArr2[j] = temp;
            i++;
            j--;
        }

    }
    private static void rotateSecondHalf(int[] myArr2, int k){
        int i = k;
        int j = myArr2.length-1;
        while (i<j){
            int temp = myArr2[i];
            myArr2[i] = myArr2[j];
            myArr2[j] = temp;
            i++;
            j--;
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
          HashMap<String, List<String>> map = new HashMap<>();
          List <List<String>> result  = new ArrayList<>();
        for (int i = 0; i <strs.length ; i++) {
            char [] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str =new String(ch);
            List<String> list = null;

            if (map.containsKey(str)){
                //get that value and add it to the list
                List l = map.get(str);
                l.add(strs[i]);
            }
            else{
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str, list);
            }

        }

        result.addAll(map.values());
        //need to get all hashmap values and return it
        return result;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        List<Integer> keys = new ArrayList<>(count.keySet());
        keys.sort((a,b)-> count.get(b) - count.get(a));

        int [] result = new int[k];
        for (int i = 0; i <k ; i++) {

            result[i] = keys.get(i);
        }


       return result;
    }

    public static String encode(List<String> strs) {

        String encoded = "";
           for (String s : strs){
               encoded += s.length()+"#"+(s);
           }
           System.out.println(encoded);

        int i =0;

        while(i < encoded.length()){
            int indexOfHash = encoded.indexOf('#', i);
            int lengthOfWord = Integer.parseInt(encoded.substring(i, indexOfHash));

            String word =encoded.substring(indexOfHash+1, indexOfHash+1+lengthOfWord);


            i = indexOfHash+1+lengthOfWord;
        }
           return encoded.toString();
    }
    public static int[] productExceptSelf(int[] nums) {

        int pref = 1;
        int [] result = new int[nums.length];
        result[0]=1;

        for (int i = 1; i <nums.length ; i++) {
            result[i] = pref * nums[i-1];
            pref = pref * nums[i-1];;
        }

        int post = 1;
        for (int i = nums.length-1; i>=0 ; i--) {
            result[i] = result[i]*post;
            post = nums[i] *post;
        }

        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
        return result;
    }
        public static int[] twoSum(int[] nums, int target) {
          int []indexArray = new int[2];
          HashMap<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i <nums.length ; i++) {
                int difference = target-nums[i];
                if(index.containsKey(difference)){
                    indexArray[0]=index.get(difference);
                    indexArray[1]=i;
                 break;
                }else{
                    index.put(nums[i], i);
                }
            }
            return indexArray;
        }

    public int longestConsecutive(int[] nums) {

        HashSet set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int i = 0; i <nums.length ; i++) {
           if(!set.contains(nums[i]-1)){
               int count = 0;
               while(set.contains(nums[i]+count)){
                   count += 1;
               }
               longest = Integer.max(longest, count);
           }

        }
        return longest;
    }
    private static int removeduplcateInPlaceReturnCount(int[] myArr) {
        int i = 0;
        int j =0;
        int count = 0;

        while(j<myArr.length){
            if (myArr[j]!=myArr[i]){
                count += 1;
                i=j;
            }
            else{
                j++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int[] twoSum2(int[] numbers, int target) {

        int low = 0;
        int high = numbers.length-1;

        while ( low<high){
            if(numbers[low] + numbers[high] == target){
                return  new int[]{low +1, high+1};
            }
            if(numbers[low] + numbers[high]<target){
                low++;
            }
            if(numbers[low] + numbers[high]>target){
                high--;
            }
        }
        return  new int[]{low+1, high+1};
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(tmp);
                    }
                }
            }
        }
        return new ArrayList<>(res);

    }
    public static boolean isPalindrome(String s) {
        String words = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(words);

        char [] characters = words.toLowerCase().toCharArray();
        int i = 0;
        int j= characters.length-1;

        while(i<j){
            if(characters[i] != characters[j]){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }


    public static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }

        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return false;
    }

    public static int maxArea(int[] heights) {
        int l = 0;
        int r  = heights.length-1;
        int area = 0;
        int res = 0;
        while(l<r){

            area = (r-l)* Integer.min(heights[l], heights[r]);
            res = Integer.max(res, area);

            if(heights[l]<heights[r]){
                l++;
            }
            else if(heights[l]>heights[r]){
                r--;
            }
            else{
                r--;
            }
        }
        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        double [] [] carAndSpeed = new double[position.length][2];
        double timeTaken = 1.0;
        Stack<Double> time = new Stack<>();
        for (int i = 0; i <position.length ; i++) {
            carAndSpeed[i][0] = position[i];
            carAndSpeed[i][1] = speed[i];
        }

        Arrays.sort(carAndSpeed, (a, b) -> Double.compare(b[0], a[0]));

      for (double[] doubles : carAndSpeed) {
          if(!time.isEmpty()){
              timeTaken = (target-doubles[0])/doubles[1];
              if(timeTaken>time.peek()){
                  time.push(timeTaken);
              }
          }
          else{
              timeTaken = (target - doubles[0]) / doubles[1];
              time.push(timeTaken);
          }

        }




        return time.size();
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            int mid = (low +high)/2;

            if(target<nums[mid]){
                high = mid -1;
            }
            else if(target >nums[mid]){
                low = mid +1;
            }
            else{
                return mid;
            }

        }
        return -1;


}


    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix.length;
        int high = matrix.length * matrix[0].length - 1;

        while (low <=high){
            int mid = (low +high)/2;

            int row = mid/matrix[0].length;
            int col = mid % matrix[0].length;

            if(target == matrix[row][col]){
                return true;
            }else if (target> matrix[row][col]){
                low = mid + 1;
            }
            else high = mid -1;

        }
      return false;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int res = 0;
        int ans = right;
        for (int pile : piles) {
            if (pile > right) {
                right = pile;
            }
        }

        while(left <= right){
            int k = (left+right)/2;
             res = 0;
            for (int i = 0; i < piles.length ; i++) {
                res += Math.ceil((double) piles[i] /k);

            }

            if(res<=h){
                ans = k;
                right = k -1;
            }
            else if(res>=h){
                left = k+1;
            }
        }
     return ans;
    }

    public int findMin(int[] nums) {
          int l = 0;
          int r = nums.length-1;
          
          while(l<=r){
              int mid = (l+r)/2;
              if(nums[mid]>nums[r]){
                  l = mid +1;
              } else {
                  r = mid;
              }

          }
          return nums[r];
    }
    public static int searchInRotatedArray(int[] nums, int target) {
         int l = 0 ;
         int r = nums.length-1;

         while(l<=r){
             int mid = (l+r)/2;

             if(nums[mid] == target){
                 return mid;
             }
             if(nums[l] <= nums[mid]){  // left half sorted
                 if(nums[l] <= target && target < nums[mid]){
                     r = mid - 1;  // search left
                 } else {
                     l = mid + 1;  // search right
                 }
             } else {  // right half sorted
                 if(nums[mid] < target && target <= nums[r]){
                     l = mid + 1;  // search right
                 } else {
                     r = mid - 1;  // search left
                 }
             }
         }
         return -1;
    }
    public static void main(String[] args) {
    int [] myArr = {0, 0, 1, 2, 2, 2, 3, 4};
        int [] myArr2 = {1,2,3,4,5,6,7};
        int val = 2;
        int k = 4;
        int [] num1 = {1,1,1,3,3,4,3,2,4,2};
        int [] nums2 = {1,1,0,1,1,1};
        int [] nums3 = {1,2,3,4};
        int [] nums4 = {-1,0,1,2,-1,-4};
        int [] nums5 = {1,7,2,5,4,7,3,6};
       int [] piles = {1,4,3,2}; int h = 9;

        int [] nums7 = {3,5,6,0,1,2}; int target = 4;
        System.out.println(searchInRotatedArray(nums7,target));

       // System.out.println(minEatingSpeed(piles, h));;
        String [] nums6 = {"1","2","+","3","*","4","-"};
       String [] strs = {"act","pots","tops","cat","stop","hat"};
        List<String> l = new ArrayList<>();
        l.add("Hello");
        l.add("World");

        l.add("How");
        l.add("are");
        l.add("you");
        int [] position = {4,1,0,7};
        int [] speed = {2,2,1,1};

        char[][] board = new char[][]{
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };
      //  isValidSudoku(board);
      //  twoSum2(nums4, 3);
        //threeSum(nums4);
      //  System.out.println(maxArea(nums5));
      //  carFleet(10, position, speed);
       // evalRPN(nums6);

//        topKFrequent(num1, 2);
       // System.out.println(isPalindrome( "tab a cat"));
        //encode(l);

       // productExceptSelf(nums3);
// List<List<String>> list =groupAnagrams(strs);
//
      int [] twonum = {3,4,5,6};

//        int [] res = revArray(myArr2);
//        for (int i = 0; i <res.length ; i++) {
//            System.out.println(res[i]);
//        }
//        rotateArray(myArr2);
//        rotateFirstHalf(myArr2, k);
//        rotateSecondHalf(myArr2, k);
//
//        for (int i = 0; i <myArr2.length ; i++) {
//          System.out.println(myArr2[i]);
//        }
//    deletingFromEnd(myArr);
        //insertAtEnd(myArr, 9, 2, 4 );
//        insertAtithIndex(myArr, 5, 2);
      // int k = removeAllOccurances(myArr,val);
//        System.out.print("First k elements: ");

       // int []  s =getConcatenation(myArr);
//        for (int i = 0; i <s.length ; i++) {
//            System.out.println(s[i]);
//        }
        //removeduplcateInPlaceReturnCount(myArr);
     //  System.out.println(removeduplcateInPlace(myArr));
        //mergeTwoSortedArray(num1, nums2);
       // moveZerosToEnd(num1);

       // findNumbers(num1);
        //consequtiveOnes(nums2);
      //  disappeared(num1);
        //containsDuplicate(num1);

     //System.out.println(isAnagram("carracevv", "racecar"));
       //int [] res =twoSum(twonum, 7);
    }
}


