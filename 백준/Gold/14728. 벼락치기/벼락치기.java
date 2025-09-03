import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[] time, score;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        int[] dp = new int[T+1000];  
        for (int i = 0; i < N; i++) {
            for (int j = T; j >= time[i]; j--) {
                dp[j] = Math.max(dp[j-time[i]]+ score[i], dp[j]);
            }
        }
        System.out.println(dp[T]);

    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        time = new int[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }
    }
}
