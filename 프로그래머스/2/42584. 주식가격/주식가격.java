import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            int price = prices[i];
            while(!stack.isEmpty() && stack.peek()[1] > price){
                int[] prev = stack.pop();
                int prevIdx = prev[0];
                answer[prevIdx] = i-prevIdx;
            }
            
            stack.push(new int[]{i,prices[i]});
        }
        while(!stack.isEmpty()){
            int[] prev = stack.pop();
            int prevIdx = prev[0];
            answer[prevIdx] = (prices.length-1) - prevIdx;
        }
        
        return answer;
    }
}