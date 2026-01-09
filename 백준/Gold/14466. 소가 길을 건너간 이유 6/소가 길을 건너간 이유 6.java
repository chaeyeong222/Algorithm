import java.io.*;
import java.util.*;

public class Main {
    static int N, K, R;
    static boolean[][][] blocked;
    static int[][] map;
    static int[][] cowPosi;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};//상하좌우
    static int[][] visited;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int cnt = 0;

        int pivot = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]==0) {
                    findGroup(i,j, pivot++);
                }
            }
        }

        int[] groupCnt = new int[pivot+1];

        for(int[] c : cowPosi){
            int idx = map[c[0]][c[1]];
            groupCnt[idx]++;
        }

        int total = K * (K-1) / 2;
        int sameGroup = 0;
        for (int i = 0; i < groupCnt.length; i++) {
            if(groupCnt[i]==0) continue;
            sameGroup += (groupCnt[i] * (groupCnt[i]-1) /2);
        }
        System.out.println(total-sameGroup);



    }
    public static void findGroup(int r, int c, int pivot){
        visited[r][c] = 1;
        map[r][c] = pivot;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int rr = temp[0];
            int cc = temp[1];
            for (int i = 0; i < 4; i++) {
                int nr = rr+dr[i];
                int nc = cc+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<N){
                    if(!blocked[rr][cc][i] && visited[nr][nc]==0){
                        que.offer(new int[]{nr,nc});
                        map[nr][nc] = pivot;
                        visited[nr][nc] = 1;
                    }
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        blocked = new boolean[N][N][4];
        cowPosi = new int[K][2];
        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;
            if(r1==r2){
                if(c1<c2){
                    blocked[r1][c1][3] = true;
                    blocked[r2][c2][2] = true;
                }else{
                    blocked[r1][c1][2] = true;
                    blocked[r2][c2][3] = true;
                }
            }else{
                if(r1<r2){
                    blocked[r1][c1][1] = true;
                    blocked[r2][c2][0] = true;
                }else{
                    blocked[r1][c1][0] = true;
                    blocked[r2][c2][1] = true;
                }
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cowPosi[i][0] = Integer.parseInt(st.nextToken())-1;
            cowPosi[i][1] = Integer.parseInt(st.nextToken())-1;
        }
    }

}