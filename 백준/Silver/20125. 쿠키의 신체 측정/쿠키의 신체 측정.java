import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int startR , startC;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        StringBuilder sb = new StringBuilder();
        findHeart();
        sb.append(startR+1).append(' ').append(startC+1).append('\n'); 
        sb.append(getLeftHand(startR, startC-1)).append(' ');
        sb.append(getRightHand(startR, startC+1)).append(' ');
        int waist = getWaist();
        sb.append(waist).append(' ');
        sb.append(getLeftLeg(startR+waist+1, startC-1)).append(' ');
        sb.append(getRightLeg(startR+waist+1, startC+1)).append(' ');
        System.out.println(sb);
    }
    public static int getWaist(){
        int cnt = 0;
        int r = startR+1;
        while(r<N && map[r][startC]=='*'){
            cnt++;
            r++;
        }
        return cnt;
    }
    public static int getRightLeg(int r, int c){
        int cnt = 0;
        while(r<N && map[r][c]=='*'){
            cnt++;
            r++;
        }
        return cnt;
    }
    public static int getLeftLeg(int r, int c){
        int cnt = 0;
        while(r<N && map[r][c]=='*'){
            cnt++;
            r++;
        }
        return cnt;
    }
    public static int getLeftHand(int r, int c){
        int cnt = 0;
        while(c>=0){
            if(map[r][c--]=='*'){
                cnt++;
            }else {
                break;
            }
        }
        return cnt;
    }
    public static int getRightHand(int r, int c){
        int cnt = 0;
        while(c<N){
            if(map[r][c++]=='*'){
                cnt++;
            }else {
                break;
            }
        }
        return cnt;
    }
    public static void findHeart(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]=='*'){
                    if(checkRange(i,j)){
                        startR = i;
                        startC = j;
                        return;
                    };
                }
            }
        }
    }
    public static boolean checkRange(int r, int c){
        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nr>=N || nc<0 || nc>=N) return false;
            if(map[nr][nc]!='*') return false;
        }
        return true;
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}