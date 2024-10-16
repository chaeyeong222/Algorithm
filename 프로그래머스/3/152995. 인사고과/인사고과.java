import java.util.*;
import java.io.*;

class Solution {  
    public int solution(int[][] scores) {
        int answer = 1; 
        int wanScore = scores[0][0]+scores[0][1];
        int wanX = scores[0][0];
        int wanY = scores[0][1];
        //근무태도 내림차순 정렬, 같다면 동료평가 오름차순 정렬 
        // 동료평가만 체크하면 됨 > 이전 값보다 작으면 안됨.
        // 근무태도가 이전값과 같다면 무조건 통과 + 동료평가의 max 가지고 있기
        // 근무태도가 이전값과 다르다면(작다면) + 이전 동료평가 보다 커야함 + max값보다 커야함 
        // 동료평가 max 일때의  (근무태도 + 동료평가 ) 기억 = 근무태도 같다면 pass, 작다면 불가
        //완호의 점수 기억 하고 그것보다 크다면 ++
        Arrays.sort(scores, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]){return o1[1] - o2[1];}
                return o2[0]-o1[0];
            }
        }); 
          
        int maxY = scores[0][1];
        
        boolean flag = false;
        for(int i=0; i< scores.length; i++){
            int nowY = scores[i][1];
            if( maxY <= nowY) {  
                maxY = Math.max(nowY, maxY);
                if(scores[i][0]+scores[i][1] > wanScore) {answer++;}
            }else{
                if(scores[i][0]==wanX && scores[i][1]==wanY){flag = true;}
            }
            if(flag) break;
        }
        
        if(flag) answer = -1;
        
        return answer;
    }
}