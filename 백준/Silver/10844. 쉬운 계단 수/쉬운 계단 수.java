import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }
        System.out.println(sum);
    }
    public static void pro(){
        dp[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][9] = dp[i-1][8];
        }

    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10];
    }
}