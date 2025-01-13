import java.io.*;
import java.util.*;
class Main {
    static Long[] dp = new Long[1000001];

    public static void main(String[] args) throws Exception {
        set();
    }
    public static Long fibo(int num){
        if(dp[num]==null){
            dp[num] = (fibo(num-2)+fibo(num-4)+fibo(num-6))%1000000009;
        }
        return dp[num];
    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 2L;
        dp[4] = 3L;
        dp[5] = 3L;
        dp[6] = 6L;

        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }
}