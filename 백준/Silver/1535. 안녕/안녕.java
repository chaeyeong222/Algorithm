import java.io.*;
import java.util.*;
//안녕
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n+1];//체력
        int[] h = new int[n+1]; //행복
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if(p[i]>=j){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-p[i]]+h[i]);
                }
            }
        }
        System.out.println(dp[n][100]);

    }
}