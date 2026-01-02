import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int answer;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr={-1,1,0,0}; // 상 하 좌 우
    static int[] dc={0,0,-1,1};
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        visited[N-1][0] = true;
        dfs(N-1,0,1);
        System.out.println(answer);
    }
    public static void dfs(int r, int c, int cnt){
        if(cnt>K) return;
        if(cnt==K){
            if(r==0 && c==M-1) answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!='T'&& !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr, nc, cnt+1);
                visited[nr][nc] = false;
            }
        }
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i]  = br.readLine().toCharArray();
        }
    }
}