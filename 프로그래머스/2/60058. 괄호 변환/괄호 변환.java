import java.util.*;

class Solution {
    public String solution(String p) { 
        if(isRight(p)) return p;
        
        String answer = pCheck(p);
         
        return answer;
    }
    public String pCheck(String p){
        if(p.equals("")) return "";
        if(isRight(p)) return p;
        
        int open = 0;
        int close = 0;
        int idx = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(') open++;
            else close++;
            if(open>0 && open==close){
                idx = i;
                break;
            }
        }
        String pa = p.substring(0,idx+1);
        String pb = p.substring(idx+1);
        
        if(isRight(pa)){
            return pa+pCheck(pb);
        }else{
            return "(" + pCheck(pb) + ")" + reverse(pa);
        }
        
    }
    public boolean isRight(String pivot){
        Stack<Character> stack = new Stack<>();
        int n = pivot.length();
        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                stack.push(pivot.charAt(i));
                continue;
            }
            char c = pivot.charAt(i);
            if(c==')' && stack.peek()=='('){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false; 
    }
    public String reverse(String p){
        StringBuilder sb = new StringBuilder(); 
        for(int i=1; i<p.length()-1; i++){
            if(p.charAt(i)=='('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        } 
        return sb.toString();
    }
}
/**
올바른 문자열인지 체크
아니면 쪼갬 > how?
*/