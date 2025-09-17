import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static final int INF = 1000 * 1000;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        int answer = INF;

        for (int start = 0; start < 3; start++) {
            int[][] dp = new int[N][3] ;
            for (int i = 0; i < 3; i++) {
                if(i==start) dp[0][i] = map[0][i];
                else dp[0][i] = INF;
            }


            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+ map[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+ map[i][1];
                dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0])+ map[i][2];
            }

            for (int end = 0; end < 3; end++) {
                if(start==end) continue;
                answer = Math.min(answer, dp[N-1][end]);
            }
        }
        System.out.println(answer);
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}