import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for(int[] command : commands){
            int len = command[1]-command[0]+1;
            int[] temp = new int[len];
            int idx = 0;
            for(int i=command[0]-1; i<command[1]; i++){
                temp[idx++] = array[i];
            }
            Arrays.sort(temp);
            answer[index++] = temp[command[2]-1];
        }
        return answer;
    }
}