
import java.io.*;
class Main {
    static int N;
    static long[]  dp;
    public static void main(String[] args) throws Exception {
        set();

        pro();
        System.out.println(dp[N]);
    }
    public static void pro( ){
        dp[0]=0;
        dp[1]=1;

        if(N>1) dp[2] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

    }
}