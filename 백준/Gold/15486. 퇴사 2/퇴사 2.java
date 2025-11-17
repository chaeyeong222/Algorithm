import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] days;
    static int[] profit;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int[] dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            int a = days[i];
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            if(i+a<=N) {
                dp[i+a] = Math.max(dp[i+a],dp[i]+profit[i]);
            }
        }

        int max = 0;
        for (int i = 0; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        days = new int[N];
        profit = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }
    }
} 