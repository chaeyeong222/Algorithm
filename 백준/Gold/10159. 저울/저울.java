import java.io.*;
import java.util.*; 

public class Main {
    static int N, M;
    static List<Integer>[] list, reverse;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int lighter = bfs(i, list);
            int heavier = bfs(i, reverse);
            sb.append(N-1-lighter-heavier).append('\n');
        }
        System.out.println(sb);
    }
    public static int bfs(int pivot, List<Integer>[] graph){
        boolean[] visited = new boolean[N+1];
        visited[pivot] = true;
        Queue<Integer> que = new LinkedList<>();
        que.offer(pivot);
        int cnt = 0;
        while(!que.isEmpty()){
            int now = que.poll(); 
            for(int next: graph[now]){
                if(!visited[next]) {
                    visited[next] = true;
                    que.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            reverse[b].add(a);
        }
    }
}