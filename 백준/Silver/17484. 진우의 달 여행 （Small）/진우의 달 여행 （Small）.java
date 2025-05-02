import javax.print.DocFlavor;
import javax.swing.*;
import java.io.*;
import java.util.*;

class Main {
    static int N, M, ans;
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(j!=0) dp[i][j][0] = Math.min(dp[i-1][j-1][1],dp[i-1][j-1][2])+ map[i][j];
                dp[i][j][1] = Math.min(dp[i-1][j][0],dp[i-1][j][2])+ map[i][j];
                if(j!=M-1) dp[i][j][2] = Math.min(dp[i-1][j+1][0],dp[i-1][j+1][1])+ map[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            int temp = dp[N-1][i][0];
            for (int j = 1; j < 3; j++) {
                temp = Math.min(temp, dp[N-1][i][j]);
            }
            ans = Math.min(ans, temp);
        }
        System.out.println(ans);

    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        map = new int[N][M];
        dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) Arrays.fill(dp[i][j], map[i][j]);
                else Arrays.fill(dp[i][j] , Integer.MAX_VALUE);
            }
        }
    }
}