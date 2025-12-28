import java.util.*;
import java.io.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<int[]>[] list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] r: road){
            int a = r[0];
            int b = r[1];
            int d = r[2];
            list[a].add(new int[]{b,d});
            list[b].add(new int[]{a,d});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        
        pq.offer(new int[]{1,0});
        dist[1] = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int now = temp[0];
            int distance = temp[1];
            if(distance > dist[now]) continue;
            for(int[] next : list[now]){
                if(dist[next[0]] > dist[now]+ next[1]){
                    dist[next[0]] = dist[now]+next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) answer++;
        }


        return answer;
    }
}