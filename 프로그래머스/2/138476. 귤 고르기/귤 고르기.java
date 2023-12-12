import java.util.*;
import java.io.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        } 
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map.keySet() ){
            // System.out.println(map.get(key));
            list.add(map.get(key));
        }
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        // System.out.println(list.toString());
        int sum = 0;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i); 
            if(sum>=k){
                
                break;
            } answer++;
        }
        
        return answer;
    }
}