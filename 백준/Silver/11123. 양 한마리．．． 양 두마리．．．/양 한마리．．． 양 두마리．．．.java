
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]=='#'){
                        cnt++;
                        check(i,j);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
    public static void check(int r, int c){
        Queue<int[]> que = new LinkedList<>();
        map[r][c] = '.';
        que.offer(new int[]{r,c});
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
               int nr = now[0] + dr[i];
               int nc = now[1] + dc[i];
               if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]=='#'){
                   map[nr][nc] = '.';
                   que.offer(new int[]{nr,nc});
               }
            }
        }
    }
}