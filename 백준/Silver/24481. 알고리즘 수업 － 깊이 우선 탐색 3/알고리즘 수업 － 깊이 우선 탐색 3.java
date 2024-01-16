import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] visited;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        //입력받은 값 넣기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        for (int i = 1; i < list.length; i++) {
            Collections.sort(list[i]);
        }

        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        dfs(R, 0);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }

    }//

    public static void dfs(int now, int depth) {
        if (visited[now] != -1) {
            return;
        }
        visited[now] = depth;
        for (int aa : list[now]) {
            dfs(aa, depth + 1);
        }
    }
}