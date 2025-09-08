import java.io.*;
import java.util.*;

public class Main {
    static int N, K; 
    static List<Node> nodes = new ArrayList<>();
    static int[] parent;
    static int[] dist;
    static long sum;
    public static void main(String[] args) throws IOException {
        set();
        pro();
        System.out.println(sum);
    }
    public static void pro(){
        Collections.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.cost-o2.cost;
            }
        });
        sum = 0;
        int cnt = 0;
        for(Node n : nodes){
            if(find(n.idx1) != find(n.idx2)){
                union(n.idx1, n.idx2);
                sum += n.cost;
                cnt++;
                if(cnt==N-1) break;
            }
        }

    }
    public static int find(int a){
        if(parent[a]!=a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    public static void union(int a, int b){
        a = parent[a];
        b = parent[b];
        if(a!=b) parent[b] = a;
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); 
        parent = new int[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a,b,cost));
        }
    }
}
class Node{
    int idx1;
    int idx2;
    int cost;
    public Node(int idx1,int idx2, int cost){
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.cost = cost;
    }
}
