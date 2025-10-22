import java.util.*;

class Solution {
    int[][] map;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
 
        for (int[] rec : rectangle) {
            int sc = rec[0] * 2;
            int sr = rec[1] * 2;
            int ec = rec[2] * 2;
            int er = rec[3] * 2;

            for (int i = sr; i <= er; i++) {
                for (int j = sc; j <= ec; j++) {
                    map[i][j] = 1;
                }
            }
        }
 
        for (int[] rec : rectangle) {
            int sc = rec[0] * 2;
            int sr = rec[1] * 2;
            int ec = rec[2] * 2;
            int er = rec[3] * 2;

            for (int i = sr + 1; i < er; i++) {
                for (int j = sc + 1; j < ec; j++) {
                    map[i][j] = 0;
                }
            }
        }
 
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    public int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.offer(new int[]{startY, startX, 0});
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == endY && now[1] == endX) return now[2];

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nr > 100 || nc < 0 || nc > 100) continue;
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, now[2] + 1});
                }
            }
        }
        return 0;
    }
}
