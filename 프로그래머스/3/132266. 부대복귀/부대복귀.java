import java.util.*;
import java.io.*;
class Solution {
    List<Integer>[] list;  
    int[] cost; //한번만 bfs 해서 통과하도록
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length]; 
        cost = new int[n+1];
        //연결된 애들 정보
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<roads.length; i++){
            int spotA = roads[i][0];
            int spotB = roads[i][1];
            list[spotA].add(spotB);
            list[spotB].add(spotA);
        }
        Arrays.fill(cost, -1); //없으면 -1 출력하도록
        find(destination); //부대원들 위치별로 도착지까지의 거리 확인하기  
        for(int i=0; i<sources.length; i++){
            answer[i] = cost[sources[i]];
        }
        return answer;
    }
    public void find(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        cost[start] = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int temp : list[now]){
                if(cost[temp]==-1){
                    cost[temp] = cost[now]+1;
                    que.add(temp);
                }
            }
        }
        return;
    }
}