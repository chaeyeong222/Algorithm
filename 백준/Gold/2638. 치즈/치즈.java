import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] visited;
    static int[][] outside;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int turn = 0;

        while(!cheeseCheck()){ //남은치즈가 있는지 체크
            turn++;
            //외부공기체크
            checkOutDoor();
            //녹기
            melting();
        }
        System.out.println(turn);
    }
    public static void melting(){
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==1){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        if(nr>=0 && nr<N && nc>=0 && nc<M && outside[nr][nc]==-1){
                            cnt++;
                        }
                    }
                    if(cnt>1){
                        list.add(new int[]{i,j});
                    }
                }
            }
        }

        //
        for(int[] temp : list){
            map[temp[0]][temp[1]]=0;
        }

    }

    public static void checkOutDoor(){
        outside = new int[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        outside[0][0] = -1;
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && outside[nr][nc]==0 && map[nr][nc]==0){
                    outside[nr][nc] = -1;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
    }

    public static boolean cheeseCheck(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==1) return false;
            }
        }
        return true;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}