import java.io.*;
import java.util.*;
//## 현명한 나이트
//(X-2,Y-1), (X-2,Y+1), (X-1,Y-2), (X-1,Y+2), (X+1,Y-2), (X+1,Y+2), (X+2,Y-1), (X+2,Y+1)
class Main {
    static int N, M, startR, startC;
    static int[][] dist;
    static int[] dr = {-2,-2,-1,-1,1,1,2,2};
    static int[] dc = {-1,1,-2,2,-2,2,-1,1};
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print() throws Exception{

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(dist[r][c]+1).append(' ');
        }
        System.out.println(sb);
    }
    public static void pro(){

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<Node> que = new LinkedList<>(); //시작
        que.offer(new Node(startR, startC));
        dist[startR][startR] = 0;

        while(!que.isEmpty()){
            Node now = que.poll(); //꺼내서
            for (int i = 0; i < 8; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr>0 && nr<=N && nc>0 && nc<=N && dist[nr][nc]==-1){
                    dist[nr][nc] = dist[now.r][now.c]+1;
                    que.offer(new Node(nr, nc));
                }
            }
        }
    }

    static void set() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());//시작점
        startC = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];
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