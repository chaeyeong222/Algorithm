import java.io.*;
import java.util.*;
class Solution {
    static int cnt = 0; 
    static int answer;
    public int solution(String s) { 
        answer = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c);
        }
        
        while(cnt<s.length()){
            cnt++;
            char temp = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(temp);
            if( checkRightArr(sb) ){ answer++;}
        }
        return answer;
    }
    public boolean checkRightArr(StringBuilder sb){
        Stack<Character> stack = new Stack<>();
        for(char cc : sb.toString().toCharArray()){
            if(cc=='[' || cc=='(' || cc=='{' ){
                stack.push(cc);
            }else  {
                if(stack.isEmpty()) return false;
                
                char top = stack.pop();
                if( (cc==']' && top!='[') 
                   || (cc==')' && top!='(') 
                   || (cc=='}' && top!='{')){
                    return false;
                } 
            }//else 
        }
        return stack.isEmpty();
         
    }
} 