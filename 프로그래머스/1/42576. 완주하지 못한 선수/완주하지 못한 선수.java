import java.io.*;
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String pa : participant ){
            map.put(pa, map.getOrDefault(pa,0)+1);
        }
        //인원체크
        HashMap<String,  Integer> check = new HashMap<>();
        for(String co : completion ){
            check.put(co, check.getOrDefault(co,0)+1);
        }
        
        for(String k : map.keySet()){
            if(!check.containsKey(k)){ 
                answer = k;
                break;
            } 
            
            if(check.containsKey(k) && (check.get(k) < map.get(k)) ){
                answer = k;
                break;
            }
        }
        
        return answer;
    }
}