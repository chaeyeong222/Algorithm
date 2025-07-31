import java.io.*;
import java.util.*;

class Main {
    static int N, M, R;
    static int[] item;
    static List<Node>[] list;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer,dijk(i));
        }
        System.out.println(answer);
    }
    public static int dijk(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
           @Override
           public int compare(Node o1, Node o2){
               return o1.cost-o2.cost;
           }
        });
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.cost > dist[now.to]) continue;

            for(Node next : list[now.to]){
                if(dist[next.to] > dist[now.to]+next.cost){
                    dist[next.to] = dist[now.to] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if(dist[i] <= M) sum+=item[i];
        }
        return sum;

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        item = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i  <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N+1];
        for (int i = 1; i  <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }
    }
}
class Node{
    int to;
    int cost;
    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}