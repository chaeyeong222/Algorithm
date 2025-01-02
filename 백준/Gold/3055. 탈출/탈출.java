import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static char[][] map;
    static int[][] water; 
    static int[][] avoid;
    static int answer;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int startR, startC;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        waterDist();
        avoidDist();
        if(answer==0) System.out.println("KAKTUS");
        else System.out.println(answer);

    }
    public static void avoidDist(){
        Queue<int[]> que2 = new LinkedList<>();
        que2.offer(new int[]{startR, startC});
        avoid[startR][startC] = 1;
        while(!que2.isEmpty()){
            int[] now = que2.poll();
            if(map[now[0]][now[1]]=='D') {
                answer = avoid[now[0]][now[1]] -1;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nc>=0 && nr<R && nc<C && avoid[nr][nc]==0){
                    if(map[nr][nc]=='.' || map[nr][nc]=='D'){
                        if((avoid[now[0]][now[1]] + 1< water[nr][nc])|| water[nr][nc]==0){
                            que2.offer(new int[]{nr, nc});
//                            System.out.println("dkdkdk+++");
                            avoid[nr][nc] = avoid[now[0]][now[1]] + 1;
                        }
                    }
                }
            }

        }

    }
    public static void waterDist(){
        Queue<int[]> que = new LinkedList<>();
        //모든 물의 시작점 다 넣기 + 고슴도치 위치 파악
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='*'){
                    que.offer(new int[]{i,j});
                    water[i][j] = 1;
                }else if(map[i][j]=='S'){
                    startR = i;
                    startC = j;
                }
            }
        }//
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc]=='.' && water[nr][nc]==0){
                    water[nr][nc] = water[now[0]][now[1]] + 1;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        water = new int[R][C];
        avoid = new int[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}