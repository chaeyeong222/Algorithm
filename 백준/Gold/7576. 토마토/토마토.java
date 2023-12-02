import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C;
    static Queue<Node> que;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        que = new LinkedList<>();
        boolean alldone = true;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) alldone = false;
                else if (map[i][j] == 1) {
                    que.offer(new Node(0,i, j));
                    map[i][j] = 1;
                }
            }
        }
        if(alldone){
            System.out.println(0);
        }else{
            int day = bfs();
            boolean flag = true; //다익었는지 체크
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j]==0){
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println(-1);
            }else{
                System.out.println(day);
            }
        }




    }

    public static int bfs() {
        int level = 0;
        while (!que.isEmpty()) {
            Node n = que.poll();
            int tempR = n.r;
            int tempC = n.c;
            visited[tempR][tempC] = true;
            for (int i = 0; i < 4; i++) {
                int nr = tempR + dr[i];
                int nc = tempC + dc[i];
                if (nr < R && nr >= 0 && nc < C && nc >= 0 && map[nr][nc] ==0) {
                    //넣어줌
                    que.offer(new Node(n.level+1, nr, nc));
                    map[nr][nc] = 1; //방문처리
                }
            }
            level = n.level;
        }
        return level;
    }

}
class Node{
    int level;
    int r;
    int c;
    Node(int level,int r, int c){
        this.level = level;
        this.r = r;
        this.c = c;
    }
}
