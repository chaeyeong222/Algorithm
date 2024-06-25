import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<=n; i++){ 
            list.add(new ArrayList<Node>()); 
        }
        
        for(int i=0; i<roads.length; i++){
            int spot1 = roads[i][0];
            int spot2 = roads[i][1];
            list.get(spot1).add(new Node(spot2,1)); 
            list.get(spot2).add(new Node(spot1,1)); 
        }
        
        //다익스트라 시작
        int[] dist = new int[n+1]; //가중치
        for(int i=0; i<n+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> que = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost,o2.cost));
        que.offer(new Node(destination,0));
        dist[destination] = 0;
        while(!que.isEmpty()){
            Node curNode = que.poll();
            if(dist[curNode.idx] < curNode.cost){
                continue;
            }
            for(int i=0; i<list.get(curNode.idx).size(); i++){
                Node nextNode = list.get(curNode.idx).get(i);
                if(dist[nextNode.idx]>nextNode.cost+curNode.cost){
                    dist[nextNode.idx] = nextNode.cost+curNode.cost;
                    que.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }//while
        
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]]==Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = dist[sources[i]];
            }
            
        }
                                                          
        
                                
        
        
        
        
        return answer;
    }
}
class Node{
    int idx, cost;
    Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}
