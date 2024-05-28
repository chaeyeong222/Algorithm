import java.util.*;
import java.io.*;

class Solution {
    public List<String> solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for(String orders : record){
            String[] temp = orders.split(" ");
            if(!temp[0].equals("Leave")){
                map.put(temp[1], temp[2]);
            };
        } 
        
        List<String> list = new ArrayList<>();
        for(String message : record){
            String[] temp = message.split(" ");
            if(temp[0].equals("Enter")){
                list.add(map.get(temp[1])+"님이 들어왔습니다.");
            }else if(temp[0].equals("Leave")){
                list.add(map.get(temp[1])+"님이 나갔습니다.");
            }
        }
        return list;
    }
}