import java.util.*;
import java.io.*;

class Solution {
    Map<String, Integer> checkIndex;
    Map<Integer, Integer> cnt;
    PriorityQueue<Play>[] pq;
    public List<Integer> solution(String[] genres, int[] plays) {
        checkIndex = new HashMap<>();
        cnt = new HashMap<>();
        pq = new PriorityQueue[genres.length];  
        int idx = 0;
        //장르별 개수 체크
        for(int i=0; i<genres.length; i++){
            String g = genres[i];
            if(!checkIndex.containsKey(g)){
                checkIndex.put(g, idx);
                pq[idx] = new PriorityQueue<>(new Comparator<Play>(){
                    @Override
                    public int compare(Play o1, Play o2){
                        return o2.playCnt - o1.playCnt;
                    }
                });
                pq[idx].add(new Play(i, plays[i]));
                cnt.put(idx++, plays[i]);
                
            }else{
                int index = checkIndex.get(g);
                pq[index].add(new Play(i, plays[i]));
                cnt.put(index, cnt.get(index)+plays[i]);
            }
        }
        //가장 많은 애부터 출력 
        PriorityQueue<Play> temp = new PriorityQueue<>(new Comparator<Play>(){
            @Override
            public int compare(Play o1, Play o2){
                return o2.playCnt - o1.playCnt;
            }
        });
        
        for(Integer e : cnt.keySet()){
            temp.add(new Play(e, cnt.get(e)));
        }
        
        List<Integer> answer = new ArrayList<>(); 
        int size = temp.size();
        for(int i=0; i<size; i++){
            Play p = temp.poll();
            int max = 2;
            if(pq[p.idx].size()<max) max = 1;
            for(int j=0; j<max; j++){
                Play t = pq[p.idx].poll();
                answer.add(t.idx);
            }
        }
        
        return answer;
    }
}
class Play{
    int idx;
    int playCnt; 
    public Play( int idx, int playCnt){
        this.idx = idx;
        this.playCnt = playCnt; 
    }
} 