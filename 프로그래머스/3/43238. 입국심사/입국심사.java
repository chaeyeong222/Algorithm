import java.util.*;
class Solution {
    int n;
    int[] times;
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        this.n = n;
        this.times = times;
        Arrays.sort(times);
        long right = (long) n * times[times.length-1];
        while(left<=right){
            long mid = (left+right)/2;
            if(check(mid)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
    public boolean check(long pivot){
        long cnt = 0 ;
        for(int i=0; i<times.length; i++){
            cnt += pivot/times[i];
            
            
            if(cnt>=n) return true;
        } 
        return false;
    }
}