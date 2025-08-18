import java.util.*;
import java.io.*;
class Solution {
    public long solution(String[][] book_time) {
        long answer = 0;
        int max = 24*60+10;
        int[] diff = new int[max+1];
        
        for(String[] bookT : book_time){
            int start = toMin(bookT[0]);
            int end = toMin(bookT[1])+10;
            diff[start]+=1;
            diff[end] -= 1; 
        }
        int[] room = new int[max+1];
        room[0] = diff[0];
        for(int i=1; i<max+1; i++){
            room[i] = room[i-1]+diff[i];
        }
        
        //누적사람계산
        for(int i=0;i<max+1; i++){
            answer = Math.max(answer, room[i]);
        } 
        return answer;
    }
    public int toMin(String min){
        String[] temp = min.split(":");
        int t = Integer.parseInt(temp[0]) * 60;
        return t+Integer.parseInt(temp[1]);
    }
}