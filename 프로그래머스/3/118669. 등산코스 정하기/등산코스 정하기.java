import java.util.*;
import java.io.*;
class Solution {
    static final int MAX = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        //연결리스트
        List<Node>[] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            list[path[0]].add(new Node(path[1], path[2]));
            list[path[1]].add(new Node(path[0], path[2]));
        }
        
        //출입구, 산봉우리 체크
        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        for(int s : summits){
            isSummit[s] = true;
        }
        for(int g : gates){
            isGate[g] = true;
        }
        
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, MAX);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
           @Override
            public int compare(Node o1, Node o2){
                return o1.dist-o2.dist;
            }
        });
        
        //출입구에서 시작, 다중 다익
        for(int g : gates){
            pq.offer(new Node(g, 0));
            intensity[g] = 0;
        }
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.dist > intensity[now.idx]) continue;
            if(isSummit[now.idx]) continue;//산봉우리면 더이상 진행x
            
            for(Node next : list[now.idx]){
                int nextCost = Math.max(now.dist, next.dist);
                if(nextCost < intensity[next.idx] && !isGate[next.idx]){
                    intensity[next.idx] = nextCost;
                    pq.offer(new Node(next.idx, intensity[next.idx]));
                }
            }
        }
        
        int bestS = 0;
        int bestIntensity = MAX;
        
        Arrays.sort(summits);
        for(int s : summits){
            if(intensity[s] < bestIntensity){
                bestS = s;
                bestIntensity = intensity[s];
            }
        }
        
        return new int[]{bestS, bestIntensity};
    }
}
class Node{
    int idx;
    int dist;
    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
}
 