import java.io.*;
import java.util.*;
//## 연구소
class Main {
    static int N, M;
    static List<Node> virus;
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
        dfs(0);
    }
    public static void dfs(int cnt){ //벽 세우기
        if(cnt==3){
            bfs(); //바이러스 퍼지기
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    map[i][j] = 1;
                    dfs(cnt+1);
                    map[i][j] = 0;
                }
            }
        }

    }
    public static void bfs(){
        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            que.offer(new Node(virus.get(i).r, virus.get(i).c));
        }

        int[][] copyMap = new int[N][M]; //원본 유지를 위한 복사
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!que.isEmpty()){
            Node now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr>=0 && nc>=0 && nr<N && nc<M && copyMap[nr][nc]==0){
                    copyMap[nr][nc] = 2;
                    que.offer(new Node(nr, nc));
                }
            }
        }

        checkVirus(copyMap);
    }
    public static void checkVirus(int[][] copyMap){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j]==0) cnt++;
            }
        }

        answer = Math.max(answer, cnt);//최댓값 갱신
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new ArrayList<>(); //바이러스 시작점
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new Node(i,j));
                }
            }
        }
        answer = 0;
    }
}
class Node{
    int r;
    int c;
    Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}