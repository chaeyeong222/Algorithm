import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] order) { 
        int N = order.length; 
        
        Stack<Integer> stack = new Stack<>();//보조   
        int wantedIdx = 0;
        for(int box=1; box<=N; box++){
            if(box==order[wantedIdx]){ 
                wantedIdx++; 
                while(!stack.isEmpty() && stack.peek()==order[wantedIdx]){ 
                stack.pop();
                wantedIdx++;
                if(wantedIdx>=N) break;
                }
            }else{
                stack.push(box);  
            }
        }
        
        while(wantedIdx< N && !stack.isEmpty() && stack.peek()==order[wantedIdx]){
            stack.pop(); 
            wantedIdx++;
        } 
        return wantedIdx;
    }
} 