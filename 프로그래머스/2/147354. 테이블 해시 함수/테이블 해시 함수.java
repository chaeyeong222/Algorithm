import java.util.*;
import java.io.*;

class Solution {
    static int[][] data; 
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        this.data = data;
        int target = col-1; 
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[target]==o2[target]){
                    return o2[0]-o1[0];
                }
                return o1[target]-o2[target];
            }
        });   
        
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int s = 0;
            for (int j = 0; j < data[0].length; j++) {
                s += data[i][j] % (i + 1); 
            }
            answer ^= s; 
        }
        return answer;
    }
}