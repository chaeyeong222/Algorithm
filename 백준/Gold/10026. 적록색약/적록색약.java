
import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map1;
    static char[][] map2;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map1 = new char[n][n];
        map2 = new char[n][n];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            map1[i] = temp.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            map2[i] = map1[i].clone();
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] != 'x') {
                    bfs(i, j);
                    cnt1++;
                }

                if (map2[i][j] != 'x') {
                    bfs2(i, j);
                    cnt2++;
                }
            }
        }//
        System.out.println(cnt1 + " " + cnt2);
    }

    public static void bfs(int r, int c) {
        char check = map1[r][c];
        Queue<int[]> que = new LinkedList<>();
        map1[r][c] = 'x';
        que.offer(new int[]{r, c});
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && map1[nr][nc] == check) {
                    map1[nr][nc] = 'x';
                    que.offer(new int[]{nr, nc});
                }
            }
        }
    }//bfs

    public static void bfs2(int r, int c) {
        char check = map2[r][c];
        if(check=='R' || check=='G'){
            Queue<int[]> que2 = new LinkedList<>();
            map2[r][c] = 'x';
            que2.offer(new int[]{r, c});
            while (!que2.isEmpty()) {
                int[] now = que2.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && (map2[nr][nc] == 'R' || map2[nr][nc] == 'G')) {
                        map2[nr][nc] = 'x';
                        que2.offer(new int[]{nr, nc});
                    }
                }
            }
        }else{
            Queue<int[]> que = new LinkedList<>();
            map2[r][c] = 'x';
            que.offer(new int[]{r, c});
            while (!que.isEmpty()) {
                int[] now = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && map2[nr][nc] == check) {
                        map2[nr][nc] = 'x';
                        que.offer(new int[]{nr, nc});
                    }
                }
            }
        }

    }//bfs

}