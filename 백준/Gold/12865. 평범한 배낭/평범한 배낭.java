import java.io.*;
import java.util.*;
//배낭
class Main {
    static int n, k;
    static int[] dp;
    static int[] value, weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        weight = new int[n+1];
        value = new int[n+1];
        dp = new int[k+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }//입력

        for (int i = 1; i <= n; i++) {
            for (int j = k; j-weight[i] >=0 ; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[k]);

    }
}