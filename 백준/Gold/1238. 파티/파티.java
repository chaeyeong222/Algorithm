import java.io.*;
import java.util.*;

public class Main {
    static int N, M, goal;
    static List<Neighbor>[] list;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        set();
        pro();
        print();
    }
    public static void print(){
        int ans = 0; 
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, answer[i]); 
        } 
        System.out.println(ans);
    }
    public static void pro(){
        for(int i=1; i<=N; i++){
            if(i==goal) continue;
            daik1(i);
            daik2(i);
        }
    }
    public static void daik1(int start){
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
            if(now.idx==goal){
                answer[start] = dist[now.idx];
                break;
            }
            for(Neighbor next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx]+next.distance){
                    dist[next.idx] = dist[now.idx]+next.distance;
                    pq.offer(new Neighbor(next.idx, dist[next.idx]));
                }
            }
        }
    }
    public static void daik2(int end){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[goal] = 0;
        PriorityQueue<Neighbor> pq = new PriorityQueue<>(new Comparator<Neighbor>(){
            @Override
            public int compare(Neighbor o1, Neighbor o2){
                return o1.distance-o2.distance;
            }
        });
        pq.offer(new Neighbor(goal, 0));
        while(!pq.isEmpty()){
            Neighbor now = pq.poll();
            if(now.idx==end){
                answer[end] += dist[now.idx];
                break;
            }
            for(Neighbor next : list[now.idx]){
                if(dist[next.idx] > dist[now.idx]+next.distance){
                    dist[next.idx] = dist[now.idx]+next.distance;
                    pq.offer(new Neighbor(next.idx, dist[next.idx]));
                }
            }
        }
    }

    static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Neighbor(b,cost));
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
