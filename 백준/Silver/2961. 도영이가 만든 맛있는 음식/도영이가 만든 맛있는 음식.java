import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] taste;
    static long answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        taste = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        answer = Long.MAX_VALUE;
        dfs(0, 1,0, false);
        System.out.println(answer);
    }
    public static void dfs(int depth, int sour, int salty, boolean check){
        if(depth == n){
            if(check){
                answer = Math.min(answer, Math.abs(sour-salty));
            }
            return;
        }
        dfs(depth+1, sour*taste[depth][0], salty+taste[depth][1], true);
        dfs(depth+1, sour, salty, check);
    }
}
