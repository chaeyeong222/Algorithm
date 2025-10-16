import java.util.*;
import java.io.*;
class Solution {
    String[] user_id, banned_id;
    Map<Integer, List<Integer>> map = new HashMap<>();
    int answer = 0;
    Set<List<Integer>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id; 
        for(int i=0; i< banned_id.length; i++){ 
            map.put(i, find(banned_id[i]));
        }
                    
        combination(0, new ArrayList<>());
        return answer;
    }
    public void combination(int idx, List<Integer> list){
        if(idx==banned_id.length){
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            if(!set.contains(sorted)) {
                set.add(sorted);
                answer++;
            }
            return;
        }
        for(int next : map.get(idx)){
            if(list.contains(next)) continue;
            List<Integer> copylist = new ArrayList<>(list);
            copylist.add(next);
            combination(idx+1, copylist);
        }
    }
    public List<Integer> find(String pivot){
        List<Integer> list = new ArrayList<>(); 
        for(int j = 0; j < user_id.length;j++){
            String user = user_id[j];
            if(user.length() != pivot.length()){
                continue;
            } 
            boolean flag = true;
            for(int i=0; i<user.length(); i++){
                if(pivot.charAt(i)!='*' && user.charAt(i)!=pivot.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(j);
            }
        }
        return list;
    }
}