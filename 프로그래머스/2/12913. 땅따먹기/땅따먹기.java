import java.util.*;
import java.io.*;
 
class Solution {  
    int solution(int[][] land) { 
        int answer = 0;
        int n = land.length;
        int[][] cnt = new int[n][4];
        for(int i=1;i<n; i++){
            land[i][0] += Math.max(Math.max(land[i-1][1],land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0],land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0],land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0],land[i-1][1]), land[i-1][2]);
        }
        for(int c : land[n-1]){
            answer = Math.max(answer, c);
        }
        return answer;
        
    }
}
 