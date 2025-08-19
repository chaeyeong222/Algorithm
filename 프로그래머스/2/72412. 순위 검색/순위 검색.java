import java.util.*;
import java.io.*;
class Solution { 
    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        for(String i : info){
            String[] parts = i.split(" ");
            String[] keys = {parts[0], parts[1], parts[2], parts[3]};
            int score = Integer.parseInt(parts[4]);
            makeKey(keys, score, 0 ,"");
        }
        
        //점수 리스트 정렬
        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }
        
        //
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++){
            String q = query[i].replaceAll(" and ", " ");
            String[] in = q.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(in[0]).append(in[1]).append(in[2]).append(in[3]);
            int score = Integer.parseInt(in[4]);
            
            String key = sb.toString();
            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }
            
            List<Integer> li = map.get(key);
            
            //이진탐색
            int idx = lowerBound(li, score);
            answer[i] = li.size() - idx; 
        }//query
        return answer; 
        } 
    public int lowerBound(List<Integer> list , int target){
        int left = 0; 
        int right = list.size();
        while(left<right){
            int mid = (left+right)/2;
            if(list.get(mid) < target) {
                left = mid+1;
            }else right = mid;
        }
        return left;
    }
    public void makeKey(String[] key , int score, int depth, String cur){
        if(depth==4){
            if(!map.containsKey(cur)){
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(score);// 맵에 점수 추가
            return;
        }
        makeKey(key, score, depth+1, cur+key[depth]);
        makeKey(key, score, depth+1, cur+"-");
    }
}  