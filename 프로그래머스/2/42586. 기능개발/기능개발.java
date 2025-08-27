import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        int[] days = new int [n];
        
        for(int i=0; i<n ; i++){
            days[i] = (100-progresses[i]+speeds[i]-1)/speeds[i];
        }
        int now = days[0];
        int cnt = 1;
        
        for(int i=1; i<n ; i++){
            if(days[i] <= now){
                cnt++;
            }else{
                answer.add(cnt);
                now = days[i];
                cnt = 1;
            }
        }
        answer.add(cnt); 
        return answer;
    }
} 