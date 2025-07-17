import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] change = new int[N+1][M+1];
        for(int[] sk : skill){
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int power = type==1? sk[5]*(-1) : sk[5];  
            change[r1][c1]+=power;
            change[r1][c2+1]-=power;
            change[r2+1][c1]-=power;
            change[r2+1][c2+1]+=power;
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){
                change[i][j] += change[i-1][j];
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=1; j<M; j++){ 
                change[i][j] += change[i][j-1];
            }
        } 
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]+change[i][j]>0) answer++;
            }
        }
        return answer;
    }
}