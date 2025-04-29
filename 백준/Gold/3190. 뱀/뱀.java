import javax.swing.*;
import java.io.*;
import java.util.*;

class Main {
    static int N, K, ans, time;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};// 오른쪽, 아래, 왼쪽, 위 순서
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static HashMap<Integer, String> hashMap;
    static Deque<Point> snake;
    static int dir;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(time);
    }
    public static void pro(){
        snake.add(new Point(0,0));
        visited[0][0] = true;
        while(true){
            time++;
            Point head = snake.peekFirst();
            int nextR = head.r + dr[dir];
            int nextC = head.c + dc[dir];
            if(!rangCheck(nextR, nextC) || visited[nextR][nextC]) break;

            snake.addFirst(new Point(nextR, nextC));
            visited[nextR][nextC] = true;

            if(map[nextR][nextC]==2) map[nextR][nextC]= 0;//사과먹음
            else{
                Point tail = snake.pollLast();
                visited[tail.r][tail.c] = false;
            }

            if(hashMap.containsKey(time)){
                String turn = hashMap.get(time);
                if(turn.equals("L")){
                    dir = (dir+3)%4;
                } else if (turn.equals("D")) {
                    dir = (dir+1)%4;
                }
            }
        }
    }
    public static boolean rangCheck(int r, int c){
        if(r>=0 && r<N && c>=0 && c<N) return true;
        return false;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = 2;
        }
        int C = Integer.parseInt(br.readLine());
        hashMap = new HashMap<>();
        snake = new LinkedList<>();
        dir = 0; //초기값 (우)
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            hashMap.put(r, dir);
        }
    }
}
class Point{
    int r;
    int c;
    Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}