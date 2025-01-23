import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    public static void pro() {
        dp = new long[N][N]; // 각 칸에 도달 가능한 경로의 개수
        dp[0][0] = 1; // 시작점에서 시작

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int move = map[r][c];
                if(move==0) continue;
                if(r+move < N) dp[r+move][c] += dp[r][c];
                if(c+move < N) dp[r][c+move] += dp[r][c];
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }

    static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}