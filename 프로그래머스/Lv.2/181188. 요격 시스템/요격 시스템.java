import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2)->{return o1[1]-o2[1];});
        
        int end = -1;
        for(int[] target : targets ){
            if( end == -1){
                answer++;
                end = target[1]-1;
                continue;
            }
            if(end <= target[1] && end >= target[0]){
                continue;
            }
            answer++;
            end = target[1]-1;
        }
        
        return answer;
    }
}