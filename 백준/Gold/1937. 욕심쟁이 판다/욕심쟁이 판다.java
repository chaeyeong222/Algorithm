import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        dp = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(dp[i][j]==0) max = Math.max(max,dfs(i,j));
            }
        }
        System.out.println(max);
    }
    public static int dfs(int r, int c){
        if(dp[r][c]>0) return dp[r][c];

        dp[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]>map[r][c]){
                 dp[r][c] = Math.max(dp[r][c], dfs(nr,nc)+1);
            }
        }
        return dp[r][c];
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}