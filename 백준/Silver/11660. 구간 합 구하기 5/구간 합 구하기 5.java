import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0) dp[i][j] = map[i][j];
                else dp[i][j] = dp[i][j - 1] + map[i][j];
            }
        }
        //
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken())-1;
            int startC = Integer.parseInt(st.nextToken())-1;
            int endR = Integer.parseInt(st.nextToken())-1;
            int endC = Integer.parseInt(st.nextToken())-1;
            sb.append(cal(startR,startC,endR,endC)).append('\n');
        }
        System.out.println(sb);

    }
    public static int cal(int sR, int sC, int eR, int eC){
        int sum = 0;
        if(sC==0){
            for (int i = sR; i <= eR; i++) {
                sum += dp[i][eC];
            }
        }else{
            for (int i = sR; i <= eR; i++) {
                sum += dp[i][eC]-dp[i][sC-1];
            }
        }
        return sum;
    }
}
