import java.util.*;
import java.io.*;
class Solution {
    int dist, split;
    long answer;
    public long solution(int dist_limit, int split_limit) {
        dist = dist_limit;//루트의 자식 제외하고 시작
        split = split_limit; 
        if(dist_limit==0) return 1;
        answer = 0; 
        dfs(0, 1, 1, 1);
        return answer;
    }
    public void dfs(long cnt, long maxSplit, long prevChild, long leaf){
        if(cnt>dist) return;//초과불가
        if(maxSplit>split) return;//초과불가
        answer = Math.max(leaf, answer);
        
        //현재 레벨에서 분배노드로 바꿀 수 있는 노드 수
        long useDist = Math.min(dist-cnt, prevChild);
        if(useDist ==0) return;
        if(maxSplit *2 <=split){
            dfs(cnt+useDist, maxSplit*2, useDist*2, leaf+useDist); //2개씩 늘리면 1개씩은 소모됨
        }
        if(maxSplit *3 <= split){
            dfs(cnt+useDist, maxSplit*3, useDist*3, leaf+(useDist*2)); //3개씩놀리면 1개씩 소모되니까 2개씩 늘어남
        }
        
    }
} 