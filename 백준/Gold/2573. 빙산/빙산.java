import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true){
            int[][] melt = new int[N][M]; // 1년 동안 녹을 양
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j] > 0){
                        int cnt = 0;
                        for(int d=0;d<4;d++){
                            int ni = i + dr[d];
                            int nj = j + dc[d];
                            if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]==0) cnt++;
                        }
                        melt[i][j] = cnt;
                    }
                }
            }

            // 녹이기
            boolean hasIce = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    map[i][j] = Math.max(0, map[i][j]-melt[i][j]);
                    if(map[i][j]>0) hasIce = true;
                }
            }

            year++;

            // 덩어리 개수 체크
            boolean[][] visited = new boolean[N][M];
            int group = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]>0 && !visited[i][j]){
                        group++;
                        if(group>=2){ // 2개 이상이면 바로 출력
                            System.out.println(year);
                            return;
                        }
                        dfs(i,j,visited);
                    }
                }
            }

            if(!hasIce){  
                System.out.println(0);
                return;
            }
        }
    }

    static void dfs(int i,int j,boolean[][] visited){
        visited[i][j] = true;
        for(int d=0;d<4;d++){
            int ni = i + dr[d];
            int nj = j + dc[d];
            if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]>0 && !visited[ni][nj]){
                dfs(ni,nj,visited);
            }
        }
    }
}
