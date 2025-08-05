import java.io.*;
import java.util.*;

class Main {
    static int N;
    static String road;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            char curr = road.charAt(i);
            for (int j = i+1; j < N; j++) {
                char next = road.charAt(j);
                if (next == nextWord(curr)) {
                    int dist = j - i;
                    if (dp[i] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[i] + dist * dist);
                    }
                }
            }
        }
        System.out.println( dp[N-1]==Integer.MAX_VALUE? -1:dp[N-1]);
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        road = br.readLine();
    }
    public static char nextWord( char now){
        if(now=='B') return 'O';
        if(now=='O') return 'J';
        return 'B';
    }
}