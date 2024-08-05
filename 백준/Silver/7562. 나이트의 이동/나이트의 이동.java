import java.io.*;
import java.util.*;

public class Main {
    public static int[] dr = {-1,-1,1,1,-2,-2,2,2};
    public static int[] dc = {-2,2,-2,2,-1,1,-1,1};
    public static int startR,startC,goalR,goalC,n;
    public static boolean[][] visited;
    public static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            StringTokenizer st;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            startR = Integer.parseInt(st.nextToken());
            startC= Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goalR = Integer.parseInt(st.nextToken());
            goalC= Integer.parseInt(st.nextToken());


            sb.append(check()).append('\n');

        }//TC
        System.out.println(sb);
    }
    public static int check(){
        int r = startR;
        int c = startC;
        visited[r][c] = true;
        int answer = 0;
        Queue<int[]>que = new LinkedList<>();
        que.offer(new int[]{r,c, 0});
        while(!que.isEmpty()){
            int[] now = que.poll();
            answer = now[2];
            if(now[0]==goalR && now[1]==goalC) break;
            for (int i = 0; i < 8; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]){
                    que.offer(new int[]{nr,nc,now[2]+1});
                    visited[nr][nc]=true;
                }
            }
        }
        return answer;

    }
}
