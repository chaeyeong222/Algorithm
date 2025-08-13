import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long answer;

    public static void main(String[] args) throws IOException {
        set();
        answer = Long.MAX_VALUE;
        dfs(N, 0); 
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer + 1);
    }

    public static void dfs(long now, long cnt) {
        if (now > M) return;       
        if (cnt >= answer) return;
        if (now == M) {
            answer = Math.min(answer, cnt);
            return;
        }

        dfs(now * 2, cnt + 1);
        dfs(now * 10 + 1, cnt + 1);
    }

    static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}
