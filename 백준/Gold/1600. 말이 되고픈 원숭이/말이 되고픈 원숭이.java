import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.ShortBuffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    //말처럼
    static int[] dr1 = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dc1 = {-1, 1, -1, 1, 2, -2, 2, -2};
    //그냥
    static int[] dr2 = {0, 0, -1, 1};
    static int[] dc2 = {-1, 1, 0, 0};
    static boolean[][][] visited;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w][k + 1];
        answer = 0;
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = bfs(0, 0, k);
        System.out.println(answer);


    }

    public static int bfs(int r, int c, int k) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c, 0, 0});
        visited[r][c][0] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nr = now[0];
            int nc = now[1];
            int horse = now[2];
            int moveCnt = now[3];

            if (nr == h - 1 && nc == w - 1) {
                return moveCnt;
            }

            for (int i = 0; i < 4; i++) {
                int nowR = nr + dr2[i];
                int nowC = nc + dc2[i];
                if (nowR >= 0 && nowR < h && nowC >= 0 && nowC < w && !visited[nowR][nowC][horse] && map[nowR][nowC] == 0) {
                    visited[nowR][nowC][horse] = true;
                    que.offer(new int[]{nowR, nowC, horse, moveCnt + 1});
                }
            }

            // 말 점프 횟수 남아 있으면 말 점프로 탐색
            if (horse < k) {
                for (int i = 0; i < 8; i++) {
                    int nowR = nr + dr1[i];
                    int nowC = nc + dc1[i];
                    if (nowR >= 0 && nowR < h && nowC >= 0 && nowC < w && !visited[nowR][nowC][horse + 1] && map[nowR][nowC] == 0) {
                        visited[nowR][nowC][horse + 1] = true;
                        que.offer(new int[]{nowR, nowC, horse + 1, moveCnt + 1});
                    }
                }
            }//

        }//while
        return -1;
    }//
}
