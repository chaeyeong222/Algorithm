import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static ArrayList<int[]>[] list ;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[num1].add(new int[]{num2, cost});
            list[num2].add(new int[]{num1, cost});
        }
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);//가장큰값으로 채워주기

        daik();
        System.out.println(dist[n]);

    }
    public static void daik(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        dist[1] = 0;
        pq.offer(new int[]{1,0});//시작값
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int now = temp[0];
            int nowDist = temp[1];
//            if(visited[now]) continue;
//            visited[now] = true;
            if(dist[now] < nowDist) continue;
            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i)[0];
                int nextWeight = list[now].get(i)[1];
                if(  dist[next] > dist[now] + nextWeight ){
                    dist[next] = dist[now]+nextWeight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }



    }

}