import java.io.*;
import java.util.*;
class Main {
    static int N;
    static List<Integer>[] list;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        dfs(1,0);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    public static void dfs(int now, int parent){
        for(int next : list[now]){
            if(next==parent) continue;
            dfs(next,now);

            dp[now][1] += Math.min(dp[next][0], dp[next][1]);
            dp[now][0] += dp[next][1];
        }
        dp[now][1]+=1;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dp = new int[N+1][2];
    }
}