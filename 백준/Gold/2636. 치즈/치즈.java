import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, C, startCheese;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int lastCheese = startCheese;
        int turn = 0;
        boolean flag = true;
        while(flag){
            turn++;
            visited = new boolean[N][M];
            checkOutdoor(); //1.외부공기체크 > visited=true
            deleteCheese(); //2.외부공기와 닿아있는 치즈 삭제
            int cheese = cntCheese(); //3.치즈개수 확인
            if(cheese==0) {
                flag = false;
                break;
            }
            lastCheese = cheese;
        }
        System.out.println(turn);
        System.out.println(lastCheese);
    }
    public static void deleteCheese(){
        List<int[]> deleteList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==1 && checkSide(i,j)) {
                    deleteList.add(new int[]{i,j});
                }
            }
        }
        for(int[] del : deleteList){
            map[del[0]][del[1]] = 0;
        }
    }public static boolean checkSide(int r, int c){
        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr>=0 && nr<N && nc>=0 && nc<M && visited[nr][nc]){
                return true;
            }
        }
        return false;
    }
    public static int cntCheese(){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;

    }
    public static void checkOutdoor(){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{R,C});
        visited[R][C] = true;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = temp[0]+dr[i];
                int nc = temp[1]+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        boolean check = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) startCheese++;
                if(!check && map[i][j]==0){
                    R = i;
                    C = j;
                    check = true;
                }
            }
        }
    }
}