import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1; // 아무 동전도 사용하지 않는 방법
        
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        return dp[n];
    }
}
