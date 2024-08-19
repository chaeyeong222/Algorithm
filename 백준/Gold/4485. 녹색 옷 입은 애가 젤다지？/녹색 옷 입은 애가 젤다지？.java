import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dist;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 1;
        while (true){
            n = Integer.parseInt(br.readLine());
            if(n==0) break;// 종료조건

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }//입력
            dist = new int[n][n]; //누적값
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            System.out.println("Problem "+ idx++ +": "+daik());

        }//while

    }
    public static int daik(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        dist[0][0] = map[0][0];
        pq.offer(new int[]{0, 0, map[0][0]});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[0]==n-1 && temp[1]==n-1) return temp[2];
            if(dist[temp[0]][temp[1]] < temp[2]) continue;
            for (int i = 0; i < 4; i++) {
                int nr = temp[0]+dr[i];
                int nc = temp[1]+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n){
                    if(dist[nr][nc] > temp[2]+map[nr][nc] ){
                        dist[nr][nc] = temp[2]+map[nr][nc];
                        pq.offer(new int[]{nr,nc,dist[nr][nc]});
                    }
                }
            }

        }
        return 0;

    }

}