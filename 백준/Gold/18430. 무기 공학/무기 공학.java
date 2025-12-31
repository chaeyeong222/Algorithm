import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static long answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr={-1,1,0,0}; // 상 하 좌 우
    static int[] dc={0,0,-1,1};
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        dfs(0, 0);
        System.out.println(answer);
    }
    public static void dfs(int idx, long sum){

        if(idx == N*M){
            answer = Math.max(answer, sum);
            return;
        }

        int r = idx / M;
        int c = idx % M;

        if (visited[r][c]) {
            dfs(idx + 1, sum);
            return;
        }
        visited[r][c] = true;
        if(rangeCheck(r,c,0,visited) && rangeCheck(r,c,3,visited)){
            visited[r+dr[0]][c+dc[0]] = true;
            visited[r+dr[3]][c+dc[3]] = true;
            dfs(idx+1, sum + map[r][c]*2+ map[r+dr[0]][c+dc[0]] + map[r+dr[3]][c+dc[3]]);
            visited[r+dr[0]][c+dc[0]] = false;
            visited[r+dr[3]][c+dc[3]] = false;
        }
        if(rangeCheck(r,c,0,visited) && rangeCheck(r,c,2,visited)){
            visited[r+dr[0]][c+dc[0]] = true;
            visited[r+dr[2]][c+dc[2]] = true;
            dfs(idx+1, sum + map[r][c]*2+ map[r+dr[0]][c+dc[0]] + map[r+dr[2]][c+dc[2]]);
            visited[r+dr[0]][c+dc[0]] = false;
            visited[r+dr[2]][c+dc[2]] = false;
        }
        if(rangeCheck(r,c,1,visited) && rangeCheck(r,c,2,visited)){
            visited[r+dr[1]][c+dc[1]] = true;
            visited[r+dr[2]][c+dc[2]] = true;
            dfs(idx+1, sum + map[r][c]*2+ map[r+dr[1]][c+dc[1]] + map[r+dr[2]][c+dc[2]]);
            visited[r+dr[1]][c+dc[1]] = false;
            visited[r+dr[2]][c+dc[2]] = false;
        }
        if(rangeCheck(r,c,1,visited) && rangeCheck(r,c,3,visited)){
            visited[r+dr[1]][c+dc[1]] = true;
            visited[r+dr[3]][c+dc[3]] = true;
            dfs(idx+1, sum + map[r][c]*2+ map[r+dr[1]][c+dc[1]] + map[r+dr[3]][c+dc[3]]);
            visited[r+dr[1]][c+dc[1]] = false;
            visited[r+dr[3]][c+dc[3]] = false;
        }
        visited[r][c] = false;
        dfs(idx+1, sum); //안씀

    }
    public static boolean rangeCheck(int r, int c, int i, boolean[][] visited){
        int nr = r+dr[i];
        int nc = c+dc[i];
        if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) return true;
        return false;
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}