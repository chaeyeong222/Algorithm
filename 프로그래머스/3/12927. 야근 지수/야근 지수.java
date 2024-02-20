import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.offer(work);
        }
        for(int i=0; i<n; i++){
            int num = (int) pq.poll();
            if(num<=0) break;
            else pq.offer(num-1);
        }
        while(!pq.isEmpty()){
            answer += (Math.pow(pq.poll(),2));
        } 
        return answer;
    }
}