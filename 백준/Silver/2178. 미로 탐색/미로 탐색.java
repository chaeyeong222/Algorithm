import java.io.*;
import java.util.*;

public class Main {
    //방향 상하좌우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N,M;
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) -'0';
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
        //bfs 시작
        bfs(0,0);

        System.out.println(map[N-1][M-1]);
    }
    public static void bfs(int r, int c){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});


        while(!que.isEmpty()){
            int[] now = que.poll();
            int nowR = now[0];
            int nowC = now[1];
            for (int i = 0; i < 4; i++) {
                int nr = nowR + dr[i];
                int nc = nowC + dc[i];
                if(nr<N && nr>=0 && nc>=0 && nc<M && map[nr][nc]==1 && !visited[nr][nc]){
                    que.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                    map[nr][nc] = map[nowR][nowC]+1;
                }
            }
        }
    }
}