import java.io.*;
import java.util.*;

class Main {
    static int[][] map, path;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        Deque<int[]> que = new ArrayDeque<>();
        path[0][0] = 0;
        que.offerFirst(new int[]{0,0});

        while(!que.isEmpty()){
            int[] now = que.poll();
            int r = now[0], c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<501 && nc>=0 && nc<501){
                    if(map[nr][nc]==-2) continue;
                    int cost = (map[nr][nc]==-1)?1:0;
                    int newCost = path[r][c] + cost;

                    if(path[nr][nc] == -1 || path[nr][nc] > newCost){
                        path[nr][nc] = newCost;
                        if(cost == 0)
                            que.offerFirst(new int[]{nr,nc}); // 비용 0이면 앞에
                        else
                            que.offerLast(new int[]{nr,nc}); // 비용 1이면 뒤에
                    }
                }
            }
        }

        System.out.println(path[500][500]);
    }


    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[501][501];
        path = new int[501][501];
        int n = Integer.parseInt(br.readLine());
        for(int k=0; k< n; k++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int startR = Math.min(y1, y2);
            int endR = Math.max(y1, y2);
            int startC = Math.min(x1, x2);
            int endC = Math.max(x1, x2);
            for (int i = startR; i <= endR; i++) {
                for (int j = startC; j <= endC; j++) {
                    map[i][j] = -1;
                }
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int k=0; k< m; k++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int startR = Math.min(y1, y2);
            int endR = Math.max(y1, y2);
            int startC = Math.min(x1, x2);
            int endC = Math.max(x1, x2);
            for (int i = startR; i <= endR; i++) {
                for (int j = startC; j <= endC; j++) {
                    map[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < 501; i++) {
            Arrays.fill(path[i], -1);
        }
    }
}