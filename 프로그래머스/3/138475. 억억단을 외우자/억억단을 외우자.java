import java.util.*;
import java.io.*;
class Solution {
    int[] dp;
    public int[] solution(int e, int[] starts) {
        int n = starts.length;
        int[] answer = new int[n];
        dp = new int[e+1];
        for(int i=1; i<=e; i++){
            for(int j=1; j<= e/i; j++){
                dp[i*j]++;
            }
        }
        
        int[] max = new int[e+1];
        max[e] = e;
        for(int i=e-1; i>=1; i--){
            if(dp[i]>=dp[max[i+1]]){
                max[i] = i;
            }else{
                max[i] = max[i+1];
            }
        }
        
        for(int i=0; i<n; i++){
            answer[i] = max[starts[i]];
        }
        return answer;
    } 
}
/**
약수의 개수? 
*/