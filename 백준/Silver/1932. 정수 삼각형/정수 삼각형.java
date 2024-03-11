import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            } 
        }

        if(n==1) System.out.println(triangle[0][0]);
        else {
            dp[0][0] = triangle[0][0];
            dp[1][0] = triangle[0][0] + triangle[1][0];
            dp[1][1] = triangle[0][0] + triangle[1][1];

            for (int i = 2; i < n; i++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
                }
            }

            int max = -1;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp[n - 1][i]);
            }

            System.out.println(max);

        }
    }
}