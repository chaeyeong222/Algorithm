import java.io.*;
import java.util.*;
class Main {
    static int N;
    static long[][] dp;
    static int[] num;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){

        for (int i = 1; i < N-1; i++) {
            for (int sum = 0; sum < 21; sum++) {
                if(dp[i-1][sum] >0){
                    if(sum + num[i] <= 20) {dp[i][sum + num[i]] += dp[i-1][sum];}
                    if(sum - num[i] >= 0) {dp[i][sum - num[i]] += dp[i-1][sum];}

                }
            }
        }
        System.out.println(dp[N-2][num[N-1]]);

    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N][21];
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][num[0]] = 1;
    }
}