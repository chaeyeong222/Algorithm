import java.util.*;
import java.io.*;

class Solution { 
    List<Integer> answer;
    Map<String, Integer> dict;
    int maxCnt, idx, n;
    public List<Integer> solution(String msg) {
        dict = new HashMap<>();
        answer = new ArrayList<>(); 
        maxCnt = 1;
        idx = 1; 
        n = msg.length(); 
        for(char c = 'A'; c<='Z'; c++){
            dict.put(String.valueOf(c), idx++);
        }
        int i=0;
        while(i<n){
            String w = "";
            int j = i;
            while(j<n){
                String temp = msg.substring(i,j+1);
                if(dict.containsKey(temp)){
                    w = temp;
                    j++;
                }else{
                    break;
                }
            }
            answer.add(dict.get(w));
            if (j < n) {
                dict.put(w + msg.charAt(j), idx++);
            }
            i+=w.length();
        }
        
        return answer;
    } 
}