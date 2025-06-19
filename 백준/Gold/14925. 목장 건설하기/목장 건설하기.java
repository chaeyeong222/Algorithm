import java.io.*;
import java.util.*;

class Main {
    static int N, M, answer;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    public static void pro() {
        int[][] dp = new int[N+1][M+1]; 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    dp[i][j] = Math.min(
                        Math.min(dp[i-1][j], dp[i][j-1]),
                        dp[i-1][j-1]
                    ) + 1;
                    answer = Math.max(answer, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(answer);
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1]; 

        for (int i = 1; i <= N; i++) { //
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
    }
}
