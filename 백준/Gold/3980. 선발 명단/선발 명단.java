
import java.io.*;
import java.util.*;

public class Main {
    static int[][] player;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int TC = 0; TC < T; TC++) {
            player = new int[11][11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;
            dfs(0,0,new boolean[11]);
            System.out.println(ans);
        }
    }
    public static void dfs(int idx, int sum, boolean[] visited){
        if(idx==11){
            ans = Math.max(sum, ans);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if(player[idx][i]==0) continue;
            if(visited[i]) continue;
            visited[i] = true;
            dfs(idx+1, sum+ player[idx][i], visited);
            visited[i] = false;
        }
    } 
}