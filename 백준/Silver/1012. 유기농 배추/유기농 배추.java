import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] farm;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());//테케 개수
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());//열
            n = Integer.parseInt(st.nextToken());//행
            int k = Integer.parseInt(st.nextToken());
            farm = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());//열
                int r = Integer.parseInt(st.nextToken());
                farm[r][c] = 1;
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (farm[i][j] != 0) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append(' ');
        }//tc
        System.out.println(sb);
    }//main

    static void dfs(int r, int c) {
        farm[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if (farm[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}//class
