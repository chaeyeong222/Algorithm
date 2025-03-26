import java.io.*;
import java.util.*;
//곡괭이 = 다이아, 철, 돌 순서
class Solution {
    static String[] minerals;
    static int answer; 
    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;
        answer = Integer.MAX_VALUE;
        findTool(picks, 0, 0);// 남은 곡괭이 개수, 부수기 시작idx, 현재피로도 
        return answer;
    }
    public void findTool(int[] picks, int startIdx, int tiredness){
        if(startIdx>= minerals.length){
            answer = Math.min(answer, tiredness);
            return;
        }
        if(tiredness > answer) {
            return;
        } 
        if(picks[0]==0 && picks[1]==0 && picks[2]==0){
            answer = Math.min(answer, tiredness);
            return;
        }
         
        for(int i=0; i<3; i++){ 
            if(picks[i]>0){
                int[] newpicks = picks.clone();
                newpicks[i]--;
                // System.out.println( "newpick[ "+i+" ] = "+newpicks[i]);
                // System.out.println("Dd "+breakRocks(i, startIdx));
                findTool(newpicks, startIdx+5, tiredness + breakRocks(i, startIdx));
            } 
        }
    }
    public int breakRocks(int tool, int startIdx){
        int sum = 0;
        int[][] fatigue = {
            {1, 1, 1},  // 다이아 곡괭이
            {5, 1, 1},  // 철 곡괭이
            {25, 5, 1}  // 돌 곡괭이
        };

        for (int i = startIdx; i < Math.min(startIdx + 5, minerals.length); i++) {
            int idx = 0;
            if (minerals[i].equals("iron")) idx = 1;
            else if (minerals[i].equals("stone")) idx = 2;
            
            sum += fatigue[tool][idx]; // 해당 곡괭이와 광물에 맞는 피로도 적용
        }
        return sum;
    }
}