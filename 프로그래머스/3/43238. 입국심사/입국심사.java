import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = times[0];
        long end = (long) times[times.length-1]*n;
        long mid; 
        while(start <= end){
            long sum = 0;
            mid = (long)((start+end)/2);
            for(int i:times){
                sum += (mid/i);
            } 
            
            if(sum >= n){
                end = mid-1;
                answer = mid;
            }else{
                start = mid+1;
            } 
        }
        return answer;
    }
}