import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n+1];
        for(int j=0; j<money.length; j++){
            int nowCoin = money[j]; 
            for(int i=1; i<=n ; i++){
                if(i-nowCoin > 0){
                    dp[i] = (dp[i]+dp[i-nowCoin])%1000000007;
                }else if(i-nowCoin==0){
                    dp[i]= (dp[i]+1)%1000000007;
                }
            }
        }
        return dp[n];
    }
}