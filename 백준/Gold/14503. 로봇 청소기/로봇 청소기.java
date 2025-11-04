import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, C, dir;
    static int[][] map;
    static int[] dr = {-1,0,1,0}; //북동남서
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int r = R;
        int c = C;
        int cnt = 0;
        while(true){
            if(map[r][c]==0){
                map[r][c] = 2;//청소했다고 표시
                cnt++;
            }
            //반시계로 돌면서 체크
            boolean cleaned = false; //이동했는지 체크
            for (int i = 0; i < 4; i++) {
                dir = (dir+3)%4;
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(map[nr][nc]==0){
                    r=nr;
                    c=nc;
                    cleaned = true;
                    break;
                }
            }

            if(!cleaned){ //이동못함 > 후진체크
                int nr = 0;
                int nc = 0;
                if(dir==0){
                    nr = r+dr[2];
                    nc = c+dc[2];
                }else if(dir==1){
                    nr = r+dr[3];
                    nc = c+dc[3];
                }else if(dir==2){
                    nr = r+dr[0];
                    nc = c+dc[0];
                }else {
                    nr = r+dr[1];
                    nc = c+dc[1];
                }
                if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=1){
                    r = nr;
                    c = nc;
                } else{
                    break;
                }
            }
        }
        System.out.println(cnt);


    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        R =  Integer.parseInt(st.nextToken());
        C =  Integer.parseInt(st.nextToken());
        dir =  Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}