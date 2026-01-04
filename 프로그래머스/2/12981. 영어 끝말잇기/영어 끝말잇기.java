import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) { 
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        int[] turns = new int[n];
        turns[0]++;
        set.add(words[0]);
        char prev = words[0].charAt(words[0].length()-1);
        for(int i=1; i<words.length; i++){
            String now = words[i];
            int person = i%n;
            
            if(words[i].charAt(0)==prev &&!set.contains(now)){
                set.add(now);
                turns[person]++;
                prev = now.charAt(now.length()-1);
            } else{
                answer[0] = person + 1;
                answer[1] = turns[person]+1;
                break;
            }
        }
        if(answer[0]==0) return new int[]{0,0};
        else return answer;
    }
}