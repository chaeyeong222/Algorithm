import java.util.*;
import java.io.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = number.length();
        int pass = n-k; // 이만큼은 개수 채워야됨  
        int cnt = 0;
        Stack<Integer> stack = new Stack<>(); 
        for(int i=0; i<n; i++){
            int now = number.charAt(i)-'0';
            if(stack.isEmpty()){ //
                stack.push(now);
                cnt++;
                continue;
            } 
            
            while(!stack.isEmpty()&& stack.peek() < now && k > 0){
                stack.pop();
                k--;
            }
            stack.push(now);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int next : stack){
            sb.append(next);
        } 
        return sb.toString();
    }
}  