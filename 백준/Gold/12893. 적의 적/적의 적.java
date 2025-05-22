import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] group;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }

        group = new int[N + 1]; // 0: 미방문, 1/2: 그룹
        flag = true;

        for (int i = 1; i <= N; i++) {
            if (group[i] == 0) {
                check(i);
                if (!flag) break;
            }
        }

        System.out.println(flag ? 1 : 0);
    }

    public static void check(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        group[start] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : list[now]) {
                if (group[next] == 0) {
                    group[next] = 3 - group[now]; // 다른 그룹으로 지정
                    que.offer(next);
                } else if (group[next] == group[now]) {
                    flag = false;
                    return;
                }
            }
        }
    }
}
