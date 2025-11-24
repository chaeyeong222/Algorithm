import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static char[][] map;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        dp = new int[N][M];
        for (int i = 0; i < N; i++) dp[i][0] = (map[i][0] == '1') ? 1 : 0;
        for (int j = 0; j < M; j++) dp[0][j] = (map[0][j] == '1') ? 1 : 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if(map[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max *max);
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}