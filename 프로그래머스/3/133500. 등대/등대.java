import java.util.*;
import java.io.*;
class Solution {
    static List<Integer>[] list;
    static int[][] dp;
    static int n;
    public int solution(int n, int[][] lighthouse) { 
        this.n = n;
        list = new ArrayList[n+1];
        dp = new int[n+1][2];
        for(int i=1; i<=n; i++){//초기화
            list[i] = new ArrayList<>();
        }
        for(int[] light : lighthouse){ //연결
            list[light[0]].add(light[1]);
            list[light[1]].add(light[0]);
        }
        
        //
        dfs(1, 0);
        return Math.min(dp[1][1], dp[1][0]);
    }
    public void dfs(int now, int parent){
        for(int next : list[now]){
            if(next==parent) continue;
            
            dfs(next , now);
            
            dp[now][1] += Math.min(dp[next][0], dp[next][1]);
            dp[now][0] += dp[next][1];
        }
        dp[now][1] += 1;
    }
}
/*
1. 연결된 애들 확인
2. 자식부터 올라가면서 최솟값확인
*/