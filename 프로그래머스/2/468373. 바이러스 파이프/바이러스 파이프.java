import java.util.*;
import java.io.*;
class Solution {
    int n, infection, k, answer;
    List<Integer>[] listA, listB, listC;
    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;
        this.n = n;
        this.infection = infection;
        this.k = k;
        listA = new ArrayList[n+1];
        listB = new ArrayList[n+1];
        listC = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            listA[i] = new ArrayList<>();
            listB[i] = new ArrayList<>();
            listC[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            int c = e[2];
            if(c==1){
                listA[a].add(b);
                listA[b].add(a);
            }else if(c==2){
                listB[a].add(b);
                listB[b].add(a);
            }else{
                listC[a].add(b);
                listC[b].add(a);
            }
        }
        
        //dfs( 횟수체크,  돌면서 최대값체크, 오염된애들 체크,숫자체크, 이전에 뭐햇는지 체크?)
        for(int i=1; i<=3; i++){
            Set<Integer> set = new HashSet<>();
            set.add(infection);
            boolean[] v = new boolean[n+1];
            v[infection] = true;
            dfs(0, set, v, i); 
        }
        return answer;
    }
    public void dfs(int cnt, Set<Integer> set, boolean[] visited, int prev){
        if(cnt>k){ //횟수초과
            return;
        }
        if(set.size()==n){
            answer = n;
            return;
        }
        if(cnt==k){
            answer = Math.max(set.size(), answer);
            return;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int s : set){
            que.offer(s);
            visited[s] = true;
        }
        while(!que.isEmpty()){
            int t = que.poll();
            if(prev==1){
                for(int next : listA[t]){
                    if(!visited[next] && !set.contains(next)){
                        visited[next] = true;
                        set.add(next);
                        que.offer(next);
                    }
                }
            }else if(prev==2){
                for(int next : listB[t]){
                    if(!visited[next]  && !set.contains(next)){
                        visited[next] = true;
                        set.add(next);
                        que.offer(next);
                    }
                }
            }else{
                for(int next : listC[t]){
                    if(!visited[next]  && !set.contains(next)){
                        visited[next] = true;
                        set.add(next);
                        que.offer(next);
                    }
                }
            }  
        }
        boolean[] copyV1 = visited.clone(); 
        boolean[] copyV2 = visited.clone();
        Set<Integer> s1 = new HashSet<>(set);
        Set<Integer> s2 = new HashSet<>(set);
        if(prev==1){
            dfs(cnt+1, s1, copyV1, 2);
            dfs(cnt+1, s2, copyV2, 3);
        }else if(prev==2){
            dfs(cnt+1, s1, copyV1, 1);
            dfs(cnt+1, s2, copyV2, 3);
        }else{
            dfs(cnt+1, s1, copyV1, 1);
            dfs(cnt+1, s2, copyV2, 2);
        }
         
    }
} 