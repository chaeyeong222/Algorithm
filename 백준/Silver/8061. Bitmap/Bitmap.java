import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] map;
    static int[][] dist;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(dist[i][j]).append(' ');
            }sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void pro(){
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i],-1);
        }
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='1'){
                    dist[i][j]=0;
                    que.offer(new int[]{i,j,0});
                }
            }
        }

        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && dist[nr][nc]==-1){
                    dist[nr][nc]= now[2]+1;
                    que.offer(new int[]{nr,nc,dist[nr][nc]});
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}