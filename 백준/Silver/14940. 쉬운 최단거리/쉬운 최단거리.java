import java.io.*;
import java.util.*;
//#14940 쉬운최단거리
class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }//입력

        checkLength(start[0],start[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(result[i][j]==0 && map[i][j]==0){
                    sb.append(0).append(' ');
                }else if(result[i][j]==0 && map[i][j]==1){
                    sb.append(-1).append(' ');
                }else{
                    sb.append(result[i][j]).append(' ');
                }
            }sb.append('\n');
        }
        System.out.println(sb);

    }
    public static void checkLength(int r, int c){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c,0});
        visited[r][c] = true;
        result[r][c] = 0;
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr<n && nr>=0 && nc<m && nc>=0 && !visited[nr][nc] && map[nr][nc]==1){
                    visited[nr][nc] = true;
                    result[nr][nc] = now[2]+1;
                    que.offer(new int[]{nr, nc, result[nr][nc]});
                }
            }
        }
    }
}