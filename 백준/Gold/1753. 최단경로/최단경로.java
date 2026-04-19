
import java.io.*;
import java.util.*;

class Main {
    static int V, E;
    static List<Node>[] list;
    static long[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        distance = new long[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(distance[i]==Long.MAX_VALUE){
                sb.append("INF").append('\n');
            }else{
                sb.append(distance[i]).append('\n');
            }
        }
        System.out.println(sb);

    }
    public static void dijkstra(int start){
        Arrays.fill(distance, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int)(o1.dist-o2.dist);
            }
        });
        distance[start] = 0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(distance[now.idx]<now.dist) continue;
            for(Node next : list[now.idx]){
                if(distance[next.idx] > distance[now.idx]+next.dist){
                    distance[next.idx] = distance[now.idx]+next.dist;
                    pq.add(new Node(next.idx, distance[next.idx]));
                }
            }
        }
    }
}
class Node{
    int idx;
    long dist;
    public Node(int idx, long dist){
        this.idx = idx;
        this.dist = dist;
    }
}