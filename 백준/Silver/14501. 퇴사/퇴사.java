
import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[][] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int day, int total) {
        if (day >= N) {
            ans = Math.max(ans, total);
            return;
        }

        // 현재 상담을 하지 않는 경우
        dfs(day + 1, total);

        // 현재 상담을 하는 경우 (상담이 끝나는 날이 퇴사일을 넘지 않을 때만)
        int t = num[day][0];
        int p = num[day][1];
        if (day + t <= N) {
            dfs(day + t, total + p);
        }
    }
}