import com.sun.media.jfxmedia.events.VideoTrackSizeListener;

import java.io.*;
import java.util.*;
//## 11403
class Main {
    static int N;
    static List<Integer>[] list;
    static int[][] map;
    static boolean[] visited;
    static int[][] answer;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(sb);
    }
    public static void pro(){

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            bfs(i);
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        for (int i = 0; i < N; i++) {
            visited[i] = false; //다시 초기화
        }

        while(!que.isEmpty()){
            int now = que.poll();
            for (int i = 0; i < N; i++) {
                if(map[now][i]==0) continue;
                if(visited[i]) continue;
                que.offer(i);
//                answer[now][i] = 1;
                visited[i] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(visited[i] ?1:0).append(' ');
        }
        sb.append('\n');
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        map = new int[N][N];
        answer = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    list[i].add(j);
                }
            }
        }//for
        sb = new StringBuilder();
    }
}