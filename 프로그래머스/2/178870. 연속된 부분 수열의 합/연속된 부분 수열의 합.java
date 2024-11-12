import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] sequence, int k) { 
        int start = 0;
        int end = 0;
        
        int n = sequence.length;
        int sum = sequence[0];
        List<int[]> list = new ArrayList<>();
        while(start<n && end<n){
            if(sum==k){
                list.add(new int[]{start,end});
            } 
            if(sum<=k){
                end++;
                if(end<n){
                    sum+=sequence[end];
                }
            }else{
                start++;
                if(start<n){
                    sum-=sequence[start-1];
                }
            } 
        }
        
        Collections.sort(list, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[]o2){
                return (o1[1]-o1[0])-(o2[1]-o2[0]);
            }
        });
        
        int[] answer = {list.get(0)[0], list.get(0)[1]}; 
        
        return answer;
    }
}