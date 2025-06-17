import java.io.*;
import java.util.*;

class Main {
    static int N,M, H, W, startR, startC, goalR, goalC;
    static int answer = -1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};//상하좌우
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    public static void pro() {

        Queue<int[]> que = new LinkedList<>(); // r,c,횟수
        que.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;
        while(!que.isEmpty()){
            int[] now = que.poll();
            int r = now[0];
            int c = now[1];
            int cnt = now[2];
            if(r==goalR && c==goalC){
                answer = cnt;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(rangeCheck(nr,nc) && !visited[nr][nc] && canMove(nr,nc)){
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr,nc,cnt+1});
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
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        startR = Integer.parseInt(st.nextToken())-1;
        startC = Integer.parseInt(st.nextToken())-1;
        goalR = Integer.parseInt(st.nextToken())-1;
        goalC = Integer.parseInt(st.nextToken())-1;
    }
    public static boolean canMove(int r, int c){
        if( r<0 || c <0 || r+H-1>=N || c+W-1>=M ) return false;
        for (int i = r; i < r+H; i++) {
            for (int j = c; j < c+W; j++) {
                if(map[i][j]==1) return false;
            }
        }
        return true;
    }
    public static boolean rangeCheck(int r, int c){
        if(r>=0 && r<N && c>=0 && c<M) return true;
        return false;
    }
}