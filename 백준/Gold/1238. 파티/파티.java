import java.io.*;
import java.util.*;

public class Main {
    static int N, M, goal;
    static List<Neighbor>[] graph, reverseGraph;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        int[] distFromX = dijk(goal, graph);
        int[] distToX = dijk(goal, reverseGraph);
        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(distFromX[i]+distToX[i], max);
        }
        System.out.println(max);

    }
    public static int[] dijk(int start, List<Neighbor>[] g ){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Neighbor> pq = new PriorityQueue<>(new Comparator<Neighbor>(){
           @Override
           public int compare(Neighbor o1, Neighbor o2){
               return o1.distance-o2.distance;
           }
        });
        pq.offer(new Neighbor(start, 0));
        while(!pq.isEmpty()){
            Neighbor now = pq.poll();
            if(now.distance > dist[now.idx]) continue;
            for(Neighbor next : g[now.idx]){
                if(dist[next.idx] > dist[now.idx]+next.distance){
                    dist[next.idx] = dist[now.idx]+next.distance;
                    pq.offer(new Neighbor(next.idx, dist[next.idx]));
                }
            }
        }
        return dist;
    }

    static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Neighbor(b,cost));
            reverseGraph[b].add(new Neighbor(a,cost));
        }
        answer = new int[N+1];

    }
}
class Neighbor{
    int idx;
    int distance;
    public Neighbor(int idx, int distance){
        this.idx = idx;
        this.distance = distance;
    }
}
