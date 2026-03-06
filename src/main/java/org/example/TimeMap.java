package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pair{
    String value;
    int timeStamp;

    Pair(String value, int timeStamp){
        this.value = value;
        this.timeStamp = timeStamp;
    }
}


public class TimeMap {
    HashMap<String , List<Pair>> keyValue = new HashMap<>();
    Pair pair;
    List<Pair> pairList= null ;
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        this.pair = new Pair(value, timestamp);
        if(keyValue.containsKey(key)){
            List<Pair> pairList1 = keyValue.get(key);
            pairList1.add(this.pair);
            keyValue.put(key,pairList1);
        }
        else {
            this.pairList = new ArrayList<Pair>();
            this.pairList.add(pair);
            this.keyValue.put(key, pairList);
        }




    }

    public String get(String key, int timestamp) {
        System.out.println(keyValue.size());
        List<Pair> pairs = keyValue.get(key);
        if (pairs == null) {
            return "";
        }
        int l = 0;
        int r = pairs.size()-1;
        Pair result= null;
        while(l<=r){
            int mid = (l+r)/2;

            if(pairs.get(mid).timeStamp == timestamp){
                result = pairs.get(mid);
                return result.value;
            }
            if(pairs.get(mid).timeStamp<= timestamp){
                result = pairs.get(mid);
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return (result == null) ? "" : result.value;
    }
}
