import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] time, score;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        int[] dp = new int[N+1];
        for (int i = 0; i < K; i++) {
            for (int j = N; j >= time[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j-time[i]]+ score[i]);
            }
        }
        System.out.println(dp[N]);
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[K];
        score = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
    }
}
