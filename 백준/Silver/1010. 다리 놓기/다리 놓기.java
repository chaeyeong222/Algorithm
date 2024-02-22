import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            dp = new int[30][30];

            //반복문으로 풀기
//            for (int i = 0; i < 30; i++) {
//                dp[i][i] = 1;
//                dp[i][0] = 1;
//            }
//            for (int i = 2; i < 30; i++) {
//                for (int j = 1; j < 30; j++) {
//                    dp[i][j] = dp[i-1][j-1]+ dp[i-1][j] ;
//                }
//            }
//            sb.append(dp[m][n]).append('\n');

            //재귀로 풀기
            sb.append(combi(m,n)).append('\n');

        }//TC
        System.out.println(sb);
    }//main
    public static int combi(int n, int r){
        if(dp[n][r] > 0) return dp[n][r];
        else if(n==r || r==0) return dp[n][r]=1;
        return dp[n][r] = combi(n-1,r-1)+combi(n-1,r);
    }
}