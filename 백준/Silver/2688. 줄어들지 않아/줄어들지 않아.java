import java.io.*;
import java.util.*;
class Main {
    static int N;
    static long[][]  dp;
    public static void main(String[] args) throws Exception {
        set();
    }
    public static void pro( ){ 
        for (int i = 0; i < 11; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= N; i++) {  
            for (int j = 1; j <= 10; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j]; 
            } 
        }
        System.out.println(dp[N-1][10]); 
    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            dp = new long[66][11];
            N = Integer.parseInt(br.readLine());
            pro();
        }
    }
}