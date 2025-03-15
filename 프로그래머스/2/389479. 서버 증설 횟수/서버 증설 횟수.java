import java.util.*;
import java.io.*;

class Solution {
    static int[] servers; 
    static int[] players;
    static int m,k;
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        this.players = players;
        this.m = m; //수용인원
        this.k = k; //증설서버운용시간
        servers = new int[24]; 
        for(int i=0; i<24; i++){
            // 서버당 감당가능한지 체크
            answer += acceptable(i);
        }
        return answer;
    }
    public int acceptable(int idx){
        if(players[idx] < servers[idx] * m + m - 1){
            return 0;
        }else{
            int add = (players[idx]/m) - servers[idx];
            for(int i=0; i<k; i++){
                if(idx+i<24){
                    servers[idx+i] += add; //증설
                }
            }
            return add;
        }
    }
}