import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] prev = new int[n+1][m+1];
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            if(type==1){ //공격
                prev[r1][c1] -= degree;
                prev[r1][c2+1] += degree;
                prev[r2+1][c1] += degree;
                prev[r2+1][c2+1] -= degree;
            }else{
                prev[r1][c1] += degree;
                prev[r1][c2+1] -= degree;
                prev[r2+1][c1] -= degree;
                prev[r2+1][c2+1] += degree;
            }
        } 
        for(int i=0; i<n; i++){
            for(int j= 1; j<m; j++){
                prev[i][j] += prev[i][j-1]; 
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j= 1; j<n; j++){
                prev[j][i] += prev[j-1][i]; 
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]+prev[i][j]>0) answer++;
            }
        }
        
        
        return answer;
    }
}