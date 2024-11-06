import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
//##
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int[][][] dp = new int[n][m][3]; //
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) Arrays.fill(dp[i][j], map[i][j]);
                else Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j!=0){ dp[i][j][0] = Math.min( dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j];}
                dp[i][j][1] = Math.min( dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];
                if(j!=m-1) { dp[i][j][2] = Math.min( dp[i-1][j+1][0], dp[i-1][j+1][1]) + map[i][j];}
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int minV = dp[n-1][i][0];
            for (int j = 1; j < 3; j++) {
                minV = Math.min(minV, dp[n-1][i][j]);
            }
            answer = Math.min(answer, minV);
        }
        System.out.println(answer);
        




    }
}