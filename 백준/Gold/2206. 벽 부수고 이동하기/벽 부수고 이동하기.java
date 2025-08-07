 

import java.io.*;
import java.util.*;

public class Main  {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited; // [row][col][벽 부쉈는지 여부]
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        set();
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 0, 1}); // r, c, 벽부숨 여부, 거리
        visited[0][0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int r = cur[0], c = cur[1], broken = cur[2], dist = cur[3];

            if (r == N - 1 && c == M - 1) return dist;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                // 벽 X
                if (map[nr][nc] == '0' && !visited[nr][nc][broken]) {
                    visited[nr][nc][broken] = true;
                    que.offer(new int[]{nr, nc, broken, dist + 1});
                }
                // 벽 O + 아직 안 부쉈을 때
                else if (map[nr][nc] == '1' && broken == 0 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    que.offer(new int[]{nr, nc, 1, dist + 1});
                }
            }
        }

        return -1;
    }

    static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}
