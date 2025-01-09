import java.io.*;
import java.util.*;
class Main {
    static int N,M;
    static List<Info>[] list;

    static int[] dist;
    static int goal, start;
    public static void main(String[] args) throws Exception {
        set();
        dijkstra(start);
        System.out.println(dist[goal]);
    }
    public static void dijkstra(int start){
        Arrays.fill(dist, Integer.MAX_VALUE);
        //최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.value - o2.value;
            }
        });

        //시작점 초기화
        dist[start] = 0;
        pq.offer(new Info(start, 0));

        while(!pq.isEmpty()){
            Info now = pq.poll();
            if(dist[now.idx] < now.value) continue;

            for( Info next : list[now.idx] ){
                if(dist[now.idx] + next.value < dist[next.idx]){
                 dist[next.idx] = dist[now.idx] + next.value;
                 pq.offer(new Info(next.idx, dist[next.idx]));
                }
            }
        }
    }
    static void set() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[num1].add(new Info(num2, value));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
    }
}
class Info{
    int idx;
    int value;

    Info(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}