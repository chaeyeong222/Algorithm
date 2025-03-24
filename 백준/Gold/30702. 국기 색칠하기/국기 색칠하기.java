import java.io.*;
import java.util.*;

class Main {
    static char[][] target;
    static char[][] goal;
    static int N, M;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {-1,1,0,0};
    static boolean[][] visited;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
            if(canBeSame()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
    }
    public static void pro(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(target[i][j]!=goal[i][j]){
                    changeColor(i,j, target[i][j], goal[i][j]);
                }
            }
        }

    }
    public static void changeColor(int r, int c,char from, char to){
        if(visited[r][c]) return;
        visited[r][c] = true;
        target[r][c] = to;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc] && target[nr][nc]==from){
                        visited[nr][nc] = true; //방문췍
                        target[nr][nc] = to; //바꿔주고
                        que.offer(new int[]{nr,nc});
                }
            }
        }
    }


    public static boolean canBeSame(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(target[i][j]!=goal[i][j]) return false;
            }
        }
        return true;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        target = new char[N][M];

        visited = new boolean[N][M];
        goal = new char[N][M];
        for (int i = 0; i < N; i++) {
            target[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            goal[i] = br.readLine().toCharArray();
        }
        flag = false;
    }
}
