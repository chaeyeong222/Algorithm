import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        int idx = 0;
        int onBridge = 0;
        int now = 0;
        
        while(idx< truck_weights.length || !que.isEmpty()){
            now++;
            
            while(!que.isEmpty() && que.peek()[1] == now){
                int[] t = que.poll();
                onBridge -= t[0]; //다리에서 제거
            }
            
            if(idx< truck_weights.length && onBridge + truck_weights[idx]<= weight){
                que.offer(new int[]{truck_weights[idx], now+bridge_length});
                onBridge += truck_weights[idx];
                idx++;
            }
        }
        return now; 
    }
}  