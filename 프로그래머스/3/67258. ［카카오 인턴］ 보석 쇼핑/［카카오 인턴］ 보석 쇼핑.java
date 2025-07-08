import java.util.*;
import java.io.*;
class Solution {
    static int N, cnt;
    static Set<String> temp; 
    static int[] answer = new int[2];
    public int[] solution(String[] gems) {  
        answer[0]=0;
        answer[1]=gems.length;
        temp = new HashSet<>();
        for(String g : gems){
            temp.add(g);
        } 
        N = temp.size();
        int start = 0;
        int end = N-1;
        int minLength = gems.length+1;
        // 짧은 구간 구하기  
        Map<String, Integer> gemCount = new HashMap<>(); 
        int left = 0;
        int next = 0;
        
        for(int right=0; right<gems.length; right++){
             gemCount.put(gems[right], gemCount.getOrDefault(gems[right],0)+1);
            while(gemCount.size()==N){
                if((right-left)< minLength){
                    start = left;
                    end = right;
                    minLength = right-left;
                }
                
                gemCount.put(gems[left], gemCount.get(gems[left])-1);
                if(gemCount.get(gems[left])==0){
                    gemCount.remove(gems[left]);
                }
                left++;
            }
        }
        answer[0] = start+1;
        answer[1] = end+1;
        return answer;
    } 
} 