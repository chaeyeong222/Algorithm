import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] weight, ball;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int max = 15001;
        boolean[][] dp = new boolean[N+1][max];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            int w = weight[i-1];
            for (int j = 0; j < max; j++) {
                if(dp[i-1][j]){
                    dp[i][j] = true;
                    if(j+w<=max) dp[i][j+w] = true;
                    dp[i][Math.abs(j-w)] = true;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int b : ball){
            if(b > max) sb.append("N ");
            else if(dp[N][b]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb);

    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        ball = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ball[i] = Integer.parseInt(st.nextToken());
        }
        
    }
}