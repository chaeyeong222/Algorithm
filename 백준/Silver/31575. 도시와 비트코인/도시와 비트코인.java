import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int N, M;
    static int[] dr = {0,1};
    static int[] dc = {1,0};
    static boolean answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        if (answer) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    public static void pro(){
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(now[0]==M-1 && now[1]==N-1){
                answer = true;
                break;
            }
            for (int i = 0; i < 2; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr<M && nc<N && nc>=0 && nc>=0 && map[nr][nc]==1 && !visited[nr][nc] ){
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        answer = false;
    }
}
