import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] visible;
    static List<int[]>[] list;
    static boolean flag ;
    static int answer ;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        boolean[] visited = new boolean[N];
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(0, 0L));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int cur = now.idx;
            long d = now.dist;

            if (visited[cur]) continue;
            visited[cur] = true;

            if(cur==N-1){
                System.out.println(d);
                return;
            }

            for(int[] next : list[cur]){
                int nx = next[0];
                int cost = next[1];

                if(visited[nx]) continue;

                long nowDist = d+cost;
                if(dist[nx] > nowDist){
                    dist[nx] = nowDist;
                    pq.offer(new Node(nx, nowDist) );
                }
            }
        }
        System.out.println(-1);

    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visible = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visible[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //갈수있는애들만 넣기
            if(a==N-1 || b==N-1){
                list[a].add(new int[]{b,cost});
                list[b].add(new int[]{a,cost});
            }else if(visible[a]==0 && visible[b]==0){
                list[a].add(new int[]{b,cost});
                list[b].add(new int[]{a,cost});
            }
        }
    }
}
class Node implements Comparable<Node>{
    int idx;
    long dist;
    Node(int idx, long dist){
        this.idx = idx;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node other){
        return Long.compare(this.dist, other.dist);
    }

}