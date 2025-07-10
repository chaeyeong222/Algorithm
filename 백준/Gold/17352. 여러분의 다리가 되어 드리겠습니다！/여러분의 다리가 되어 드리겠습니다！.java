import java.io.*;
import java.util.*;
class Main {
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        ans[0] = 1;
        bfs(1);
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                ans[1] = i;
                break;
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
    }
    public static void bfs(int idx){
        Queue<Integer> que = new LinkedList<>();
        que.offer(idx);
        visited[idx] = true;
        while(!que.isEmpty()){
            int now = que.poll();
            for (int next : list[now]){
                if(!visited[next]){
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[N+1];
        ans = new int[2];
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-2 ; i++) {
            st =  new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
    }
}