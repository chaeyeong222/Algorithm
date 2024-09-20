import java.io.*;
import java.util.*;
//##동전 9084
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            int n = Integer.parseInt(br.readLine());//가짓수
            int[] coin = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < coin.length; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int limit = Integer.parseInt(br.readLine());
            int[] dp = new int[limit+1];
            for (int i = 0; i < n; i++) {
                int now = coin[i];
                for (int j = 1; j <= limit; j++) {
                    if(j-now > 0){
                        dp[j] = dp[j]+dp[j-now];
                    }else if(j-now==0){
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[limit]).append('\n');
        }
        System.out.println(sb);
    }
}