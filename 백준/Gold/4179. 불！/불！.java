import java.io.*;
import java.util.*;

class Main {
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int r, c;
    static int[][] fireRoad;
    static int[][] jihunRoad;
    static Queue<int[]> que1; // 불의 큐
    static Queue<int[]> que2; // 지훈이의 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        fireRoad = new int[r][c];
        jihunRoad = new int[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                fireRoad[i][j] = -1;
                jihunRoad[i][j] = -1;
                if (map[i][j] == 'F') {
                    que1.offer(new int[]{i, j});
                    fireRoad[i][j] = 0; // 불의 초기 위치
                }
                if (map[i][j] == 'J') {
                    que2.offer(new int[]{i, j});
                    jihunRoad[i][j] = 0; // 지훈이의 초기 위치
                }
            }
        }

        spreadFire();       // 불의 BFS
        findEscapeRoot();   // 지훈이의 BFS
    }

    public static void spreadFire() {
        while (!que1.isEmpty()) {
            int[] now = que1.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                if (fireRoad[nr][nc] >= 0 || map[nr][nc] == '#') continue;
                fireRoad[nr][nc] = fireRoad[now[0]][now[1]] + 1;
                que1.offer(new int[]{nr, nc});
            }
        }
    }

    public static void findEscapeRoot() {
        while (!que2.isEmpty()) {
            int[] now = que2.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    System.out.println(jihunRoad[now[0]][now[1]] + 1);
                    return;
                }
                if (jihunRoad[nr][nc] >= 0 || map[nr][nc] == '#') continue;
                if (fireRoad[nr][nc] != -1 && fireRoad[nr][nc] <= jihunRoad[now[0]][now[1]] + 1) continue;
                jihunRoad[nr][nc] = jihunRoad[now[0]][now[1]] + 1;
                que2.offer(new int[]{nr, nc});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}