import java.util.*;
class Solution {
    int n,m;
    int distance, answer;
    int[] rocks;
    public int solution(int distance, int[] rocks, int n) {
        answer = 0;
        this.n = n;
        this.rocks = rocks;
        m = rocks.length;
        this.distance = distance;
        Arrays.sort(rocks);
        int left = 0;
        int right = 1000000000;
        while(left<=right){
            int mid = (left+right)/2;
            if(check(mid)){
                left = mid+1;
                answer = mid;
            }else{
                right = mid-1;
            }
        }
        return answer;
    }
    public boolean check(int pivot){
        int prev = 0;
        int cnt=0;
        for(int i=0; i<m; i++){
            if(rocks[i]-prev<pivot){
                cnt++;
            }else{
                prev = rocks[i];
            }
            if(cnt>n) return false; 
        }
        
        if(distance-prev<pivot) cnt++;
        if(cnt>n) return false;
        return true; 
    }
}