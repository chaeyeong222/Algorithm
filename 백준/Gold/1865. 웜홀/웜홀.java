import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int start, end, cost;
        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static final int INF = 100000000; // 충분히 큰 값 설정
    static int N, M, W;
    static List<Edge> edges;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, cost));
                edges.add(new Edge(b, a, cost)); // 도로는 양방향
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, -cost)); // 웜홀은 단방향, 시간이 감소하므로 -cost
            }

            if (hasNegativeCycle()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }

    static boolean hasNegativeCycle() {
        dist = new int[N + 1];
        Arrays.fill(dist, 0); // 모든 노드를 0으로 초기화 (가상의 노드를 추가하는 효과)

        // 벨만-포드 실행 (N번 반복)
        for (int i = 1; i <= N; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;
                    updated = true;
                }
            }
            // 만약 더 이상 갱신이 일어나지 않는다면 조기 종료
            if (!updated) break;
        }

        // 음수 사이클 확인 (N번째 반복)
        for (Edge edge : edges) {
            if (dist[edge.end] > dist[edge.start] + edge.cost) {
                return true; // 음수 사이클 존재
            }
        }
        return false;
    }
}
