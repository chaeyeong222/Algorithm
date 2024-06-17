import java.util.*;
import java.io.*;
class Solution {
    static boolean[] visited; 
    static int answer;
    public int solution(int k, int[][] dungeons) { 
        answer = 0;  
        visited = new boolean[dungeons.length];
        for(int i=0; i<dungeons.length; i++){ 
            visited[i] = true;
            if(k>=dungeons[i][0]) {
              check(k-dungeons[i][1], 1 , dungeons);
            }
            visited[i] = false;
        } 
        return answer;
    }
    public void check(int power, int depth, int[][] dungeons){
        answer = Math.max(depth, answer);
        //방문체크
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && power>=dungeons[i][0]){
                visited[i] = true;
                check(power-dungeons[i][1], depth+1, dungeons);
                visited[i] = false;
            }
        }  
    }
}