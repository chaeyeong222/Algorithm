import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] cp;
    static final long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        long[][] dp = new long[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            for (int k = 0; k <= K ; k++) {
                long best = INF;

                for (int j = i-1; j >=1; j--) {
                    int skip = i-j-1;
                    if(skip > k) break;

                    long prev = dp[j][k-skip];
                    if(prev== INF) continue;

                    long cand = prev+dist(j,i);
                    if(cand<best) best = cand;
                }
                dp[i][k] = best;
            }
        }
        long ans = INF;

        for (int i = 0; i <= K; i++) {
            ans = Math.min(ans, dp[N][i]);
        }
        System.out.println(ans);



    }
    public static long dist(int a, int b){
        return (long)Math.abs(cp[a][0]-cp[b][0])+Math.abs(cp[a][1]-cp[b][1]);
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cp = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cp[i][0] = Integer.parseInt(st.nextToken());
            cp[i][1] = Integer.parseInt(st.nextToken());
        }
    }

}