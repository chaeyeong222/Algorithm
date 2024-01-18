
import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {1,0};
    static int[] dc = {0,1};
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//

        boolean flag = true;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        visited[0][0]=true;
        out : while(!que.isEmpty()) {
            //현재위치체크
            int[] position = que.poll();
            int r = position[0];
            int c = position[1]; 
            //이동 간격 체크
            int movable = map[r][c];
            if(movable==-1) {
                flag = false;
                System.out.println("HaruHaru");
                break;
            }
            //이동횟수가 남아있을때까지 계속이동 + que에 넣기
            for (int i = 0; i < 2; i++) {
                int nr = r + (dr[i]*movable);
                int nc = c + (dc[i]*movable);
                if(nr<N && nc<N && !visited[nr][nc]){
                    if(map[nr][nc]==-1){
                        flag = false;
                        System.out.println("HaruHaru");
                        break out;
                    }
                    visited[nr][nc]=true;
                    que.offer(new int[]{nr,nc});
                }
            }
        }//
        if(flag) System.out.println("Hing");


    }
}