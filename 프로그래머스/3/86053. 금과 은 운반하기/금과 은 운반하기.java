import java.util.*;
import java.io.*;

class Solution {
    int n;
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long start = 0;
        long end = (long)1e15;
        n = g.length;
        while(start<= end){
            long mid = (start+end)/2;
            
            if(canDeliver(a,b,g,s,w,t, mid)){
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return answer;
    }
    public boolean canDeliver(int a, int b, int[] g, int[] s, int[] w, int[] t, long time ){
        long totalGold = 0;
        long totalSilver = 0;
        long total = 0;
        
        for(int i=0; i<n; i++){
            long cnt = time / (2*t[i]);
            if(time%(2*t[i])>=t[i]){
                cnt++;
            }
            
            //운반가능한 최대 중량
            long capacity = cnt * w[i];
            
            //실제옮길 수 있는 양
            long goldMove = Math.min(g[i], capacity);
            long silverMove = Math.min(s[i], capacity);
            long totalMove = Math.min(g[i]+s[i], capacity);
            
            totalGold += goldMove;
            totalSilver +=silverMove;
            total += totalMove; 
        }
        
        if(totalGold >= a && totalSilver >= b && total >= a+b) return true;
        else return false;
    
    }
}  