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
        int direct = findRoot(0,0, N-1, M-1, false); //원래걸리는시간

        int withTool = -1;
        int toTool = findRoot(0,0,toolR, toolC, false);
        if(toTool !=-1){
            int fromTool = Math.abs((N-1) - toolR) + Math.abs((M-1) - toolC);
            withTool = toTool + fromTool;
        }

        int result = -1;
        if(direct !=-1 && direct<=T){
            result = direct;
        }

        if(withTool!= -1 && withTool<=T){
            if(result == -1){
                result = withTool;
            }else {
                result = Math.min(direct, withTool);
            }
        }
        if(result==-1){
            System.out.println("Fail");
        }else {
            System.out.println(result);
        }

    }
    public static int findRoot(int r, int c, int goalr, int goalc, boolean hasTool){
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
                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]){
                    if(hasTool || map[nr][nc]!=1){
                        visited[nr][nc]= true;
                        que.offer(new int[]{nr,nc,now[2]+1});
                    }
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