import java.util.*;
class Solution {
    List<Integer>[] list;
    int n;
    int answer;
    boolean[] visited;
    int[] info;
    public int solution(int[] info, int[][] edges) { 
        n = info.length;
        this.info = info;
        list = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        } 
        List<Integer> candidates = new ArrayList<>();
        for(int[] e : edges){  //부모자식연결
            if(e[0]==0) candidates.add(e[1]);
            list[e[0]].add(e[1]);
        } 
        visited[0] = true;
        move(0, 1, 0, candidates);
        return answer;
    }
    public void move(int now, int sheep, int wolf, List<Integer> candidates){
        // if(allVisited()) return;
        if(sheep<=wolf){
            return;
        } 
        if(sheep>answer){
            answer = sheep;
        }
        List<Integer> copyList = new ArrayList<>(candidates);
        for(int next : list[now]){
            if(!visited[next]){
                copyList.add(next);
            }
        }
        for(int next: copyList){
            if(!visited[next]){
                visited[next] = true;
                int type = info[next];
                if(type==0) move(next, sheep+1, wolf, copyList);
                else move(next, sheep, wolf+1, copyList);
                visited[next] = false;
            }
            
        }
        
        
    }
    public boolean allVisited(){
        for(int i=0; i<visited.length; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}