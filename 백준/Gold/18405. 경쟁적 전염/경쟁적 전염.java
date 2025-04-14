import java.io.*;
import java.util.*;

class Main {
    static int N,K,S,X,Y;
    static int[][] map;
    static Queue<int[]> que ;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<Point> pos;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        System.out.println(map[X-1][Y-1]);
    }
    public static void pro(){
        que = new LinkedList<>();

        Collections.sort(pos, new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2){
                return o1.idx - o2.idx;
            }
        });

        for(Point temp : pos){
            que.offer(new int[]{temp.r, temp.c, 0});
        }

        while(!que.isEmpty()){
            int[] now = que.poll();
            if(now[2]>S) continue;
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc]==0 &&now[2]<S){
                    que.offer(new int[]{nr,nc,now[2]+1});
                    map[nr][nc] = map[now[0]][now[1]];
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        pos = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0){
                    pos.add(new Point(map[i][j], i,j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }
}
class Point{
    int idx ;
    int r;
    int c;
    Point(int idx, int r, int c){
        this.idx = idx;
        this.r = r;
        this.c = c;
    }
}