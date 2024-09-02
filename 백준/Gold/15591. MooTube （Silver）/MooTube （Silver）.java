import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static List<Video>[] list;
    static int[][] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList();
        }
        result = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(result[i],Integer.MAX_VALUE);
        }
        //입력
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[num1].add(new Video(num2, cost));
            list[num2].add(new Video(num1, cost));
        }
        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int limit = Integer.parseInt(st.nextToken());
            int pivot = Integer.parseInt(st.nextToken());
            sb.append(findVideo(pivot, limit)).append('\n');
        }
        System.out.println(sb);
    }
    public static int findVideo( int origin,  int limit){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(origin);
        int cnt = 0;

        boolean[] check = new boolean[n+1];
        check[origin] = true;

        while(!pq.isEmpty()){
            int cur = pq.poll();
            for(Video next : list[cur] ){
                if(!check[next.idx] && limit <= next.weight){
                    pq.offer(next.idx);
                    check[next.idx] =true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
//class Video implements Comparable<Video>{
class Video {
    int idx;
    int weight;
    public Video(int linkedNum, int weight){
        this.idx = linkedNum;
        this.weight = weight;
    }
//    @Override
//    public int compareTo(Video other){
//        return this.weight - other.weight;
//    }
}