import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][][] dp = new long[n][n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //0가로 1세로 2대각선
        dp[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if(map[i][j]==1) continue;
                dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][2]; //가로
                if(i==0) continue; //첫줄은 가로만 가능
                dp[i][j][1] = dp[i-1][j][1]+dp[i-1][j][2];//세로
                if(map[i-1][j]==1 || map[i][j-1]==1) continue; //대각
                dp[i][j][2] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
            }
        }
        System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);
    }

}