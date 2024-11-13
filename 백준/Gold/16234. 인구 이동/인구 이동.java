import java.util.*;
import java.io.*;

public class Main {
    static int n, min, max;
    static int[][] map;
    static List<int[]> list;
    static boolean[][] visited ;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true){
            boolean move = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        int sum = findTotalPopulation(i,j);
                        if(list.size()>1){
                            move = true;
                            int avg = sum/list.size();
                            movePopulation(avg);
                        }
                    }
                }
            }
            if(!move) break;
            answer++;
        }
        System.out.println(answer);
    }
    public static int findTotalPopulation(int r, int c){
        list = new ArrayList<>();
        list.add(new int[]{r,c});
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});

        visited[r][c] = true;

        int sum = map[r][c];
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr<n && nr>=0 && nc<n && nc>=0 && !visited[nr][nc]){
                    int diff = Math.abs(map[now[0]][now[1]] - map[nr][nc]);
                    if(diff<=max && diff >=min){
                        que.offer(new int[]{nr, nc});
                        sum += map[nr][nc];
                        visited[nr][nc] = true;
                        list.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return sum;
    }
    public static void movePopulation(int pivot){
        for (int[] now : list){
            int r = now[0];
            int c = now[1];
            map[r][c] = pivot;
        }
    }

}//class