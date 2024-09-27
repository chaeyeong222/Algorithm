import java.io.*;
import java.util.*;
//##17144 미세먼지안녕
class Main {
    static int top, bottom, r,c;
    static int[][] map;
    static int[] dr = {0,-1,0,1}; //우상좌하
    static int[] dc = {1,0,-1,0}; //우상좌하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        top = -1;
        bottom = -1;
        //입력
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1 && top==-1) top = i;
                else if((map[i][j]==-1 && top!=-1)) bottom = i;
            }
        }
        for (int i = 0; i < t; i++) {
            map = spread();
            clean();
        }
        System.out.println( cal() );
    }
    public static int[][] spread(){
        int[][] temp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]==-1) {
                    temp[i][j] = -1;
                    continue;
                }
                temp[i][j] += map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nr = i+dr[k];
                    int nc = j+dc[k];
                    if(nr>=0 && nc>=0 && nr<r && nc<c && map[nr][nc]!=-1){
                        temp[nr][nc] += (map[i][j]/5);
                        temp[i][j] -= (map[i][j]/5);
                    }
                }
            }
        }
        return temp;
    }//spread
    public static void clean(){
        //윗부분
        int upR = top;

        for (int i = upR-1; i > 0; i--) { //왼
            map[i][0] = map[i-1][0];
        }
        for (int i = 0; i < c-1 ; i++) { //상
            map[0][i] =  map[0][i+1];
        }

        for (int i = 0; i < upR; i++) { //오
            map[i][c-1] = map[i+1][c-1];
        }
        for (int i = c-2; i > 0 ; i--) { //하
            map[upR][i+1] =  map[upR][i] ;
        }
        map[upR][1] = 0;
        ////////////////////////
        int downR = bottom;

        for (int i = downR+1; i < r-1; i++) { //왼
            map[i][0] = map[i+1][0];
        }
        for (int i = 0; i < c-1; i++) { //하
            map[r-1][i] = map[r-1][i+1];
        }

        for (int i = r-1; i > downR ; i--) { //오
            map[i][c-1] = map[i-1][c-1];
        }

        for (int i = c-1; i > 1 ; i--) { //상
            map[downR][i] = map[downR][i-1] ;
        }

        map[downR][1] = 0;
    }
    public static int cal(){
        int sum = 2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum+=map[i][j];
            }
        }
        return sum;
    }
}