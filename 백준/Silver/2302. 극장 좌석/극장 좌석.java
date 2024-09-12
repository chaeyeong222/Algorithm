import java.io.*;
import java.util.*;
//##2302 극장좌석
class Main {
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] fix = new int[m];
        for (int i = 0; i < m; i++) {
            fix[i] = Integer.parseInt(br.readLine());
        }
        dp = new Integer[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        int answer = 1;

        int before = 0;
        for (int i = 0; i < m; i++) {
            answer *= (dp[fix[i] - before -1]);
            before = fix[i];
        }
        answer *= (dp[n-before]);
        System.out.println(answer);
    }
}