import java.util.*;
import java.io.*;
class Solution {
    int n;
    int[][] dungeons; 
    int[] visited;
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        n = dungeons.length; 
        visited = new int[n];
        this.dungeons = dungeons;
        
        travel(0, 0, k);
        return answer;
    }
    public void travel(int depth, int cnt, int tired){
        if(depth>n) return;
        if(cnt>answer){
            answer = cnt; 
        }
        if(depth==n){  
            return;
        }
        if(tired<0) return;
        for(int i=0; i<n; i++){
            if(visited[i]==0 && dungeons[i][0]<=tired){ 
                visited[i] = 1; //방문처
                travel(depth+1, cnt+1, tired-dungeons[i][1]);
                visited[i] = 0;
            }
        }
        
        
    }
}