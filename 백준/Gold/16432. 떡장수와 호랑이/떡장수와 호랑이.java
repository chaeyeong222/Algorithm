import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] tteoks;
    static int[] answer;
    static boolean found = false;
    static boolean[][] visited; // [day][prevTteok] prevTteok: 0~9

    public static void main(String[] args) throws IOException {
        input();
        visited = new boolean[N][10]; // 떡 종류 1~9, prev는 0~9까지 사용
        dfs(0, 0); // 첫날 prev = 0 (0은 의미 없음)
        if (!found) {
            System.out.println("-1");
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tteoks = new ArrayList[N];
        answer = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            tteoks[i] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                tteoks[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void dfs(int day, int prev) {
        if (found) return;
 
        if (day == N) {
            for (int i = 0; i < N; i++) {
                System.out.println(answer[i]);
            }
            found = true;
            return;
        }

        if (visited[day][prev]) return;
        visited[day][prev] = true;

        for (int t : tteoks[day]) {
            if (t != prev) {
                answer[day] = t;
                dfs(day + 1, t);
                if (found) return;
            }
        }
    }
}
