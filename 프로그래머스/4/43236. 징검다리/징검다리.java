import java.util.*;
class Solution {
    int k, n, distance;
    int[] rocks;
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        k = rocks.length;
        this.distance = distance;
        this.rocks = rocks;
        this.n = n;
        if(k==n) return distance;
        Arrays.sort(rocks); //바위정렬
        int start = 1;
        int end = distance;
        while(start<=end){
            int mid = (start+end)/2;
            if(countRock(mid)){
                answer = Math.max(answer,mid);
                start = mid+1;
            }else{
                end = mid-1;
                
            } 
        }
        
        return answer;
    }
    public boolean countRock(int mid){
        int prev = 0;
        int cnt = 0;
        for(int i=0; i<k; i++){
            if(rocks[i]-prev < mid){
                cnt++;
            }else{
                prev = rocks[i];
            }
            if(cnt>n) return false;
        }
        if(distance-prev<mid){
            cnt++;   
        }
        if(cnt>n) return false;
        return true;
    }
}