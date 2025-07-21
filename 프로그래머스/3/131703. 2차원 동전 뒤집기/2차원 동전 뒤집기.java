import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = Integer.MAX_VALUE;
        int N = beginning.length;
        int M = beginning[0].length;
        for(int i=0; i<(1<<N); i++){
            int[][] temp = copyArray(beginning);
            int flipCnt = 0;
            
            for(int j=0; j<N; j++){
                if((i & (1<<j))!=0){ //i번째 행 뒤집기
                    flipRow(temp, j);
                    flipCnt++;
                }
            }
            
            boolean falg = true;
            for(int j=0; j<M; j++){
                boolean needFlip = false;
                for(int k=0; k<N; k++){
                    if(temp[k][j] != target[k][j]){
                        needFlip = true;
                        break;
                    }
                }
                if(needFlip){
                    flipCol(temp, j);
                    flipCnt++;
                }
            }
            if(isSame(temp, target)){
                answer = Math.min(answer,flipCnt);
            } 
        }
        return answer==Integer.MAX_VALUE?-1 : answer;
    }
    public void flipRow(int[][] arr, int row){
        for(int i=0; i<arr[0].length; i++){
            arr[row][i]^=1;
        }
    }
    public void flipCol(int [][] arr, int col){
        for(int i=0; i<arr.length; i++){
            arr[i][col]^=1;
        }
    }
    public int[][] copyArray(int[][] begin){
        int[][] arr = new int[begin.length][begin[0].length];
        for(int i=0; i<begin.length; i++){
            arr[i] = Arrays.copyOf(begin[i], begin[i].length);
        }
        return arr;
    }
    public boolean isSame(int[][] a, int [][] b){
        for(int i=0; i<a.length;i++){
            for(int j=0; j<a[0].length; j++){
                if(a[i][j]!=b[i][j]) return false;
            }
        }
        return true;
    }
}