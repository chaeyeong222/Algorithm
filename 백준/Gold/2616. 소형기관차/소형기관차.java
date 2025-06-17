import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] num, sum;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        sum = new int[N+1];
        int[][] dp = new int[4][N+1];
        sum[0] = num[0];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1]+num[i];
        }
        for (int i = 1; i < 4; i++) {
            for (int j = i*M; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-M] + (sum[j]-sum[j-M]));
            }
        }
        System.out.println(dp[3][N]);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N+1];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
    }
}