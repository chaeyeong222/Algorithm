import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[] d = {60, 10, -10, 1, -1};
    static String[] dp = new String[61]; // 0~60까지

    // 두 문자열 비교 (사전순 및 합계 비교)
    static boolean cmp(String a, String b) {
        int la = 0, lb = 0;
        for (int i = 0; i < 5; i++) {
            la += a.charAt(i) - '0';
            lb += b.charAt(i) - '0';
        }
        if (la != lb) return la < lb;
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기화
        for (int i = 0; i <= 60; i++) {
            dp[i] = "99999";
        }
        dp[0] = "00000";

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        // BFS 탐색
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int k = 4; k >= 0; k--) {
                int nxt = cur + d[k];
                if (nxt < 0 || nxt > 60) continue;

                StringBuilder tmp = new StringBuilder(dp[cur]);
                tmp.setCharAt(k, (char)(tmp.charAt(k) + 1));

                String tmpStr = tmp.toString();

                if (cmp(tmpStr, dp[nxt])) {
                    dp[nxt] = tmpStr;
                    q.offer(nxt);
                }
            }
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            int[] ans = new int[5];
            // 60초 단위 먼저 처리
            ans[0] = N / 60;
            N %= 60;

            for (int i = 0; i < 5; i++) {
                ans[i] += dp[N].charAt(i) - '0';
            }

            for (int i = 0; i < 5; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
