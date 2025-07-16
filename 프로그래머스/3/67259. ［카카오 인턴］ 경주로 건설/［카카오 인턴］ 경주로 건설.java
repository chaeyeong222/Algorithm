import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {-1,1,0,0};//상하좌우
    static int[] dc = {0,0,-1,1};
    static int N,M;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        N = board.length;
        M = board[0].length;
        int[][][] cost = new int[N][M][4];
        
        for(int[][] arr : cost){
            for(int[] row : arr){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        Queue<int[]> que = new LinkedList<>();
        for(int d=0; d<4; d++){
            cost[0][0][d] = 0;
            que.offer(new int[]{0,0,0,d});
        }
        
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int r = temp[0];
            int c = temp[1];
            int money = temp[2];
            int dir = temp[3];
             
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<M && board[nr][nc]==0){
                    int addCost = money + (dir==i?100:600);
                    if(cost[nr][nc][i]>addCost){
                        cost[nr][nc][i] = addCost;
                        que.offer(new int[]{nr,nc,addCost, i});
                    }
                }
            }
        }
        for(int d=0; d<4; d++){
            answer = Math.min(answer, cost[N-1][M-1][d]);
        }
        return answer;
    }
}