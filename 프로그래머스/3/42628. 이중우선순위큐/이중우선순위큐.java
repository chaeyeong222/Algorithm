import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1,o2) -> o2-o1);
    
        for(String o : operations){
            String[] temp = o.split(" ");
            int num = Integer.parseInt(temp[1]);
            if(temp[0].equals("I")){
                pq1.offer(num);
                pq2.offer(num);
                map.put(num, map.getOrDefault(num,0)+1);
            }else{
                if(num<0){ 
                    while(!pq1.isEmpty()){
                        int x = pq1.poll();
                        if(map.get(x)>0){
                            map.put(x, map.get(x)-1);
                            break;
                        }
                    } 
                }else{ 
                    while(!pq2.isEmpty()){
                    int x = pq2.poll();
                    if(map.get(x)>0){
                        map.put(x, map.get(x)-1);
                        break;
                    }
                }}
            }
        }
        if(pq1.isEmpty() || pq2.isEmpty()){
            return new int[]{0,0};
        }
        
        int max = 0;
        while(!pq2.isEmpty()){
            int x = pq2.poll();
            if(map.get(x)>0) {
                max = x;
                break;
            }
        }
        int min = 0;
        while(!pq1.isEmpty()){
            int x = pq1.poll();
            if(map.get(x)>0) {
                min = x;
                break;
            }
        } 
        return new int[]{max,min};
    }
}