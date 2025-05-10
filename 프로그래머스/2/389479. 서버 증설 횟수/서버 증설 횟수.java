import java.util.*;
import java.io.*;
class Solution {
    static Map<Integer, Integer> map;
    public int solution(int[] players, int m, int k) {
        map = new HashMap<>();//서버감소시간, 개수
        int answer = 0;
        int nowServer = 1;
        for(int i=0; i<players.length; i++){
            int now = players[i];
            if(map.containsKey(i)){ //운영끝난 서버 제외
                nowServer-=map.get(i);
            }
            if(players[i] >= m*nowServer){
                int cnt = (players[i]/m - (nowServer-1));
                nowServer += cnt;
                answer += cnt;
                map.put(i+k,cnt);
            }
        }
        return answer;
    }
}