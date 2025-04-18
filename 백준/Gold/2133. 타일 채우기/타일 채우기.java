import java.io.*;
import java.util.*; 
public class Main  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = 3*dp[i-2];
            for (int j = 4; j <=i; j+=2) {
                dp[i] += 2 * dp[i-j];
            }
        }
        System.out.println(dp[n]);
    }
}