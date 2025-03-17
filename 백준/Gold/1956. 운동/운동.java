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
        int min = INF;
        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <= N; j++) {
                if(dist[i][j]!=INF && dist[j][i]!=INF){
                    min = Math.min(min, dist[i][j]+dist[j][i]);
                }
            }
        }
        if (min == INF) {
            System.out.println(-1);
        }else System.out.println(min);
    }
    public static void pro() {
        for (int k = 1; k <= N ; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        //자기 자신은 0
//        for (int i = 1; i <= N; i++) {
//            dist[i][i] = 0;
//        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = cost; //단방향
        }

    }
}
