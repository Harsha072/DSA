package org.example;


import java.util.*;

import static org.example.Practice2.topKFrequent;
import static org.example.Practice2.union;


class Practice2 {
    public static Integer[] union(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                list.add(a[i]);
                i++;
            }
            else if (a[i] > b[j]) {
                list.add(b[j]);
                j++;
            }
            else {
                list.add(a[i]);
                i++;
                j++;
            }
        }
        while (i < a.length) {
            list.add(a[i]);
            i++;
        }
        while (j < b.length) {
            list.add(b[j]);
            j++;
        }
        return  list.toArray(new Integer[0]);

    }

    public static int[]  topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry  : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        arr.sort((a,b)-> b[0]-a[0]);
         int [] res = new int[k];
        for (int i = 0; i <res.length ; i++) {
            res[i] = arr.get(i)[1];
            System.out.println(res[i]);
        }
        return res;
    }

}
public class Main {
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5, 6};
        int [] b = {1, 2, 7, 8, 9, 10};
       // Integer [] result = (union(a, b));
        //System.out.println(Arrays.toString(result));
        int [] c = {1, 1, 2, 2, 2, 3};
topKFrequent(c,2);
        System.out.println("Hello world!");
    }
}