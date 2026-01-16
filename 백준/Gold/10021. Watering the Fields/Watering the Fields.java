import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] pipe;
    static List<Edge> list;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        checkDistance();

        //정렬
        Collections.sort(list, new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2){
                return Long.compare(o1.dist, o2.dist);
            }
        });

        long answer = 0;
        int picked = 0;
        for(Edge e : list){
            int a = e.from;
            int b = e.to;
            
            if(find(a) != find(b)){
                union(a,b);
                answer += e.dist;
                picked++;
            }
            
            if(picked==N-1) break;
        }
        if(picked!=N-1){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
    public static void union(int a, int b){
        int na = find(a);
        int nb = find(b);
        if(na != nb){
            parents[nb] = na;
        }
    }
    public static int find(int a){
        if(parents[a] != a){
            return parents[a] = find(parents[a]);
        }
        return parents[a];
    }
    public static void checkDistance(){
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int w = (pipe[i][0]-pipe[j][0])*(pipe[i][0]-pipe[j][0]) + (pipe[i][1]-pipe[j][1])*(pipe[i][1]-pipe[j][1]);
                if( w >= M){
                    list.add(new Edge(i,j,w));
                }
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pipe = new int[N][2];
        list = new ArrayList<>();
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pipe[i][0] = Integer.parseInt(st.nextToken());
            pipe[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
class Edge{
    int from ;
    int to;
    long dist;
    Edge(int from, int to, long dist){
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}