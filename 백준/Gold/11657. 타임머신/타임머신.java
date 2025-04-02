import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static List<Edge> list;
    static boolean flag;
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        if(flag){
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if(dist[i]==INF){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(dist[i]).append('\n');
                }
            }
            System.out.print(sb);
        }else {
            System.out.println(-1);
        }
    }
    public static void pro() {
        dist = new long[n+1];
        Arrays.fill(dist, INF);

        dist[1] = 0; //출발노드
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Edge now = list.get(j);
                if(dist[now.start]!=INF && dist[now.end] > dist[now.start] + now.cost ){
                    dist[now.end] = dist[now.start] + now.cost;
                }
            }
        }
        minusCycleCheck();

    }
    public static void minusCycleCheck(){
        for (int i = 0; i < m; i++) {
            Edge temp = list.get(i);
            if(dist[temp.start]!=INF && dist[temp.end] > dist[temp.start]+temp.cost){
                flag = false;
                break;
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost= Integer.parseInt(st.nextToken());

            list.add(new Edge(a,b,cost));
        }
        flag = true;

    }
}
class Edge{
    int start;
    int end;
    int cost;
    Edge(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
