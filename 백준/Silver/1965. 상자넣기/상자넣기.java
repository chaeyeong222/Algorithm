import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] box;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        int max = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(box[j]<box[i] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(max);


    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
    }
}