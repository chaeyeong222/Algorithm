import java.io.*;
import java.util.*;

class Main {
    static int[][] dist;
    static int N, M;
    static final int INF = 1000000000;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) sb.append(0).append(' ');
                else if(dist[i][j]==INF) sb.append(0).append(' ');
                else sb.append(dist[i][j]).append(' ');
            }sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void pro() {
        for (int mid = 1; mid <= N; mid++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                   if(dist[i][j] > dist[i][mid] + dist[mid][j]){
                       dist[i][j] = dist[i][mid] + dist[mid][j];
                   }
                }
            }
        }

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(cost, dist[a][b]);
        }

    }
}
