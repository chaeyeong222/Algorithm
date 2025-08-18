import java.util.*;
import java.io.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int pt = toSec(play_time);
        int at = toSec(adv_time);
        if(pt==at) return "00:00:00";
        
        long[] diff = new long[pt+2];
        for(String log : logs){
            String[] l = log.split("-");
            int start = toSec(l[0]);
            int end = toSec(l[1]);
            diff[start]+=1;
            diff[end]-=1; 
        }
        
        //누적 시청자수
        long[] view = new long[pt+1];
        view[0] = diff[0];
        for(int i=1; i<=pt; i++){
            view[i] = view[i-1]+diff[i];
        }
        //누적 시청시간
        long[] psum = new long[pt+1];
        psum[0] = view[0];
        for (int i = 1; i <= pt; i++) {
            psum[i] = psum[i-1] + view[i];
        }
        
        long best = psum[at-1];
        long bestTime = 0;
        for(int i=1; i+at-1<= pt; i++){
            int r = i+at-1;
            long cur = psum[r] - psum[i-1];
            if (cur > best) {
                best = cur;
                bestTime = i;
            }
        }
        return toStr(bestTime);
    }
    public int toSec(String time){
        String[] temp = time.split(":");
        int t = 0;
        t += Integer.parseInt(temp[0])*3600;
        t += Integer.parseInt(temp[1])*60;
        t += Integer.parseInt(temp[2]);
        return t;
    }
    
    public String toStr(long time){
        long h = time/3600;
        time %=3600;
        long m = time/60;
        time %=60;
        return String.format("%02d:%02d:%02d", h, m, time);
    }
}