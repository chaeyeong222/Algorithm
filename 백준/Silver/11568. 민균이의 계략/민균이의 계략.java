import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] num, dp;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j= 0; j < i; j++) {
                if(num[j]<num[i] && dp[j]+1 > dp[i] ){
                    dp[i] = dp[j]+1;
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        System.out.println(answer);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        answer = 1;
    }
}