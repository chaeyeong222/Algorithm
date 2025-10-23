import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T, toolR, toolC;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int original = findRoot(0,0, N-1, M-1); //원래걸리는시간

        int findTool = findRoot(0,0,toolR, toolC);
        int breakWall = Math.abs((N-1)-toolR) + Math.abs((M-1)-toolC);

        if(original==-1 && findTool==-1) { //둘다불가능
            System.out.println("Fail");
            return;
        }
        //1은가능2는불가능
        if(original!=-1 && findTool==-1 && original<=T){
            System.out.println(original);
            return;
        }
        //1은불가능 2는 가능
        if(original==-1 && findTool!=-1 && findTool+breakWall <=T){
            System.out.println(findTool+breakWall);
            return;
        }
        //둘다가능
        if(original!=-1 && findTool!=-1){
            int minTime = Math.min(original, findTool+breakWall);
            if(minTime <= T) {
                System.out.println(minTime);
            } else {
                System.out.println("Fail");
            }
            return;
        }

        System.out.println("Fail");

    }
    public static int findRoot(int r, int c, int goalr, int goalc){
        boolean[][] visited = new boolean[N][M];
        visited[r][c] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c,0});
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(now[0]==goalr && now[1]==goalc){
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=1 && !visited[nr][nc]){
                    visited[nr][nc]= true;
                    que.offer(new int[]{nr,nc,now[2]+1});
                }
            }
        }
        return -1;
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    toolR = i;
                    toolC = j;
                }
            }
        }
    }
}