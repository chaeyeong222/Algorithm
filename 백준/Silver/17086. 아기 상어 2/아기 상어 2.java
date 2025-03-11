import java.io.*;
import java.util.*;

class Main {
    static int[][] map, dist;
    static int N, M;
    static int[] dr = {-1,-1,-1,0,0,1,1,1};
    static int[] dc = {-1,0,1,-1,1,-1,0,1};
    static Queue<int[]> que;

    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }

    public static void print() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }
        System.out.println(max);
    }

    public static void pro() {
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int r = now[0];
            int c = now[1];
            int ndist = now[2];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >=0 && nc < M && dist[nr][nc]==-1){
                    dist[nr][nc] = ndist + 1;
                    que.offer(new int[]{nr, nc, ndist + 1});
                }
            }
        }
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    dist[i][j] = 0; // 상어가 있는 곳은 거리 0
                    que.offer(new int[]{i, j, 0});
                } else {
                    dist[i][j] = -1; // 아직 방문하지 않은 곳
                }
            }
        }
    }
}
