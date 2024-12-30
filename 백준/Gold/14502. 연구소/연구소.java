import java.io.*;
import java.util.*;
//## 연구소
class Main {
    static int N, M, B;
    static List<int[]> virus;
    static boolean[][] visited;
    static int[][] wall;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    public static void pro(){
        //모든 벽들의 위치를 먼저 모아놓는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0) {
                    B++;
                    wall[B][0] = i;
                    wall[B][1] = j;

                }
            }
        }
        dfs(0);
    }
    public static void check(int[][] copyMap){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j]==0) cnt++;
            }
        }
        answer = Math.max(cnt, answer);
    }
    //바이러스 퍼짐
    static void bfs(){

        visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        //시작점 다 담기
        for (int i = 0; i < virus.size(); i++) {
            que.offer(virus.get(i));
            visited[virus.get(i)[0]][virus.get(i)[1]]= true;
        }

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!que.isEmpty()){
            int[] temp = que.poll();
            int r = temp[0];
            int c = temp[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc] && copyMap[nr][nc]==0){
                    visited[nr][nc] = true;
                    copyMap[nr][nc] = 2;
                    que.offer(new int[]{nr,nc});
                }
            }
        }

        check(copyMap);

    }

    // cnt는 지금까지 세운 벽의 개수
    static void dfs(int cnt ){
        if(cnt==3) {
            //벽 다세움
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    map[i][j]= 1;
                    dfs(cnt+1);
                    map[i][j]= 0;
                }
            }
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }
        answer = 0;
        visited = new boolean[N][M];
        wall = new int[N*M][2];

    }
}