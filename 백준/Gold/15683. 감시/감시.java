import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] unreachable;
    static int[] dr = {-1,1,0,0}; //상하좌우
    static int[] dc = {0,0,-1,1};
    static List<int[]>[] numPosition ;
    static int answer = Integer.MAX_VALUE;
    static List<CCTV> cctvs = new ArrayList<>();
    static int[][][] DIRS = {
            {},
            {{0}, {1}, {2}, {3}},
            {{2, 3}, {0, 1}},
            {{0,3},{1,3},{2,1},{2,0}},
            {{0,1,2}, {1,2,3}, {0,2,3}, {0,1,3}}
    };
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        fillNum5();

        //이제 경우의 수 체크
        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int idx){
        if(idx==cctvs.size()){
            //사각지대 개수 계산
            int temp = cnt();
            answer = Math.min(answer, temp);
            return;
        }

        CCTV cur = cctvs.get(idx);

        for(int[] dirs : DIRS[cur.num]){
            List<int[]> change = new ArrayList<>();

            for(int d : dirs){
                watch(cur.r, cur.c, d, change);
            }
            dfs(idx+1);

            for(int[] p : change){
                unreachable[p[0]][p[1]] = 0;
            }
        }
    }
    public static void watch(int r, int c, int dir, List<int[]> change){
        int nr = r+dr[dir];
        int nc = c+dc[dir];
        while(nr>=0 && nr<N && nc>=0 && nc<M){
            if(map[nr][nc]==6) break;

            if(unreachable[nr][nc]==0){
                unreachable[nr][nc] = 1;
                change.add(new int[]{nr,nc});
            }
            nr+=dr[dir];
            nc+=dc[dir];
        }
    }
    public static void fillNum5(){
        for(int[] now : numPosition[5]){
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                while(nr >= 0 && nr<N && nc>=0 && nc<M ) {
                    if(map[nr][nc]==6) break;
                    unreachable[nr][nc] = 1;
                    nr+=dr[i];
                    nc+=dc[i];
                }
            }
        }
    }
    public static int cnt(){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && unreachable[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        unreachable = new int[N][M];
        map = new int[N][M];
        numPosition = new ArrayList[7];
        for (int i = 1; i < 7; i++) {
            numPosition[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0 && map[i][j]<5){
                    unreachable[i][j] = 1;
                    numPosition[map[i][j]].add(new int[]{i,j});
                    cctvs.add(new CCTV(i,j,map[i][j]));
                }else if(map[i][j]==5){
                    numPosition[map[i][j]].add(new int[]{i,j});
                    unreachable[i][j] = 1;
                }else if(map[i][j]==6){
                    unreachable[i][j] = 1;
                }
            }
        }

    }
}
class CCTV{
    int r;
    int c;
    int num;
    public CCTV(int r, int c, int num){
        this.r = r;
        this.c = c;
        this.num = num;
    }
}