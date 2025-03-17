import java.io.*;
import java.util.*;

class Main {
    static int[][] dist;
    static int N, M;
    static final int INF = 1000000000; // 매우 큰 값

    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }

    // 최단 경로 출력
    public static void print() {
        int min = INF;

        // 모든 dist[i][j]와 dist[j][i]를 확인하여 사이클 길이의 최소값을 찾기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                    // i -> j와 j -> i가 모두 가능하면 사이클 길이를 계산
                    min = Math.min(min, dist[i][j] + dist[j][i]);
                }
            }
        }

        // 사이클이 존재하지 않으면 -1 출력
        if (min == INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    // 플로이드-와샬 알고리즘
    public static void pro() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // i -> j 경로가 더 짧으면 갱신
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    // 입력 처리
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];

        // dist 배열 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        // 자기 자신으로 돌아오는 경로는 0으로 설정
        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
        }

        // 도로 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(cost, dist[a][b]); // 단방향 도로
        }
    }
}
