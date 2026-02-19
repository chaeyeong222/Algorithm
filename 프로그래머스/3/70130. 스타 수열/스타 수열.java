import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] a) { 
        int[] cnt = new int[a.length];
        for(int i : a){
            cnt[i]++;
        }
        int maxLen = 0;
        
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]<=maxLen/2) continue;
            int pair = 0;
            for(int j=0; j<a.length-1; j++){
                if((a[j]==i || (a[j+1]==i)) && (a[j]!=a[j+1])){
                    pair++;
                    j++;
                }
            } 
            maxLen = Math.max(maxLen, pair * 2);
        }
        
        return maxLen;
    }
}