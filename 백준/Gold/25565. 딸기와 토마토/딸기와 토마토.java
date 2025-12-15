import java.io.*;
import java.util.*;
public class Main {
    static int N, M, T, totalSeed;
    static int[][] map, colMap, rowMap;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        // 완벽하게 겹침
        if(totalSeed==T){
            printAllSeed();
            return;
        }
        //아예 안겹침
        if(totalSeed == 2*T){
            System.out.println(0);
            return;
        }
        //가로평행
        if(checkParallel(true)) return;
        //세로평행
        if(checkParallel(false)) return;
        //십자가
        checkCross();
    }
    public static boolean checkParallel(boolean isRow){
        int outer = isRow? N:M;
        int inner = isRow? M:N;

        for (int i = 1; i <= outer; i++) {
            int j = 1;
            while (j<=inner){
                if((isRow? map[i][j]:map[j][i])==0){
                    j++;
                    continue;
                }

                int start = j;
                while(j<=inner && (isRow? map[i][j]:map[j][i])==1){
                    j++;
                }
                int end = j-1;

                if(end-start+1>T){
                    StringBuilder sb = new StringBuilder();
                    int overlapLen = 0;

                    int overlapStart = end-T+1;
                    int overlapEnd = start+T-1;

                    for (int k = overlapStart; k <= overlapEnd; k++) {
                        overlapLen++;
                        if(isRow) sb.append(i).append(' ').append(k).append('\n');
                        else sb.append(k).append(' ').append(i).append('\n');
                    }
                    System.out.println(overlapLen);
                    System.out.println(sb);
                    return true;
                }
            }
        }
        return false;
    }
    public static void checkCross(){
        checkGaro();
        checkSero();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(colMap[i][j]==1 && rowMap[i][j]==1){
                    cnt++;
                    sb.append(i).append(' ').append(j).append('\n');
                }
            }
        }
        if(cnt==0) System.out.println(0);
        else {
            System.out.println(cnt);
            System.out.println(sb);
        }
    }
    public static void printAllSeed(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(map[i][j]==1){
                    sb.append(i).append(' ').append(j).append('\n');
                }
            }
        }
        System.out.println(T);
        System.out.println(sb);
    }
    public static void checkGaro(){
        for (int i = 1; i <= N; i++) {
            int j = 1;
            while(j<=M){
                if(map[i][j]==0) {
                    j++;
                    continue;
                }

                int start = j;
                while (j<=M && map[i][j]==1) j++;
                int end = j-1;

                if(end-start+1>=T){
                    for (int k = start; k <= end; k++) {
                        rowMap[i][k] = 1;
                    }
                }
            }
        }
    }
    public static void checkSero(){
        for (int i = 1; i <= M; i++) {
            int j = 1;
            while(j<=N){
                if(map[j][i]==0) {
                    j++;
                    continue;
                }
                int start = j;
                while(j<=N && map[j][i]==1) j++;
                int end = j-1;

                if(end-start+1 >= T){
                    for (int k = start; k <= end; k++) {
                        colMap[k][i] = 1;
                    }
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        colMap = new int[N+1][M+1];
        rowMap = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) totalSeed++;
            }
        }
    }
}