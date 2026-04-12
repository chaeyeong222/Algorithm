import java.util.*;
class Solution { 
    int[][] cost, hint;
    int n,k; 
    int minCost = Integer.MAX_VALUE;
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        n = hint.length+1;  //라운드 별 힌트 개수
        int[] nowHints = new int[n];
        solve(0, nowHints, 0); //depth, 힌트개수, 모인비용
        return minCost;
    }
    public void solve(int depth, int[] nowHints, int money){
        if(depth==n-1){
            int m = Math.min(nowHints[n-1], n-1);
            money+= cost[n-1][m]; //마지막 라운드 비용 더하기
            minCost = Math.min(minCost, money);
            return;
        }
        
        //힌트 안사는 경우 > 이미 가지고 있는 힌트개수로만 처리
        int[] copy = nowHints.clone();
        int hintCnt = Math.min(nowHints[depth], n-1); //가지고 있는 힌트 개수
        solve(depth+1, copy, money+cost[depth][hintCnt]);
        
        //힌트 사는 경우
        int[] copy2 = nowHints.clone();
        int hintCost = hint[depth][0]; //힌트비용
        for(int i=1; i<hint[depth].length; i++){
            int t = hint[depth][i];
            copy2[t-1]++; 
        }
        int hintCnt2 = Math.min(copy2[depth], n-1); //가지고 있는 힌트 개수
        solve(depth+1, copy2, money+hintCost+cost[depth][hintCnt2]);
        
    }
} 