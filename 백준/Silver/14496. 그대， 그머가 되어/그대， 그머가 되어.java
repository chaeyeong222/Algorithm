import java.io.*;
import java.util.*;
class Main {
    static int N, pivot1, pivot2, M;
    static List<Integer>[] list;
    static int answer = -1;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    public static void pro() {
         boolean[] visited = new boolean[N+1];
         Queue<int[]> que = new LinkedList<>();
         visited[pivot1] = true;
         que.offer(new int[]{pivot1,0}); //목적지, depth
        while(!que.isEmpty()){
            int[] now = que.poll();
            int idx = now[0];
            int depth = now[1];
            if(idx==pivot2){
                answer = depth;
                return;
            }
            for(int next: list[idx]){
                if(!visited[next]){
                    visited[next] = true;
                    que.offer(new int[]{next, depth+1});
                }
            }
        }
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        pivot1 = Integer.parseInt(st.nextToken());
        pivot2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M ; i++) {
            st =  new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
    }
}