import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[3][n];

            for (int i = 1; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int[][] dp = new int[3][n]; //0선택x 1행 2행
            for (int i = 0; i < 3; i++) {
                dp[i][0] = map[i][0];
            }
            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max( dp[0][i-1]+map[0][i], Math.max(dp[1][i-1]+map[0][i], dp[2][i-1]+map[0][i]));
                dp[1][i] = Math.max(dp[0][i-1]+map[1][i], dp[2][i-1]+map[1][i]);
                dp[2][i] = Math.max(dp[0][i-1]+map[2][i], dp[1][i-1]+map[2][i]);
            }
            sb.append(Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1]))).append('\n');

        }//TC
        System.out.println(sb);
    }
}
