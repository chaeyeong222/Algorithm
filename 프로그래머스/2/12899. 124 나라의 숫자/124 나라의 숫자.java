import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while(n>0){
            if(n%3==1){
                sb.append(1); 
            }else if(n%3==2){
                sb.append(2); 
            }else{
                sb.append(4);
                n--;
            }
            n/=3;
        }
        return sb.reverse().toString();
    }
}