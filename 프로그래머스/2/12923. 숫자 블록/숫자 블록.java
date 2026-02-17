import java.util.*;
import java.io.*;
class Solution {
    public long[] solution(long begin, long end) {
        long[] answer = new long[(int)(end-begin+1)];
        int idx = 0;
        for(long i=begin; i<=end; i++){
            if(i==1){
                answer[idx++]=0;
                continue;
            }
            long max = 1;
            for(long j=2; j*j<=i; j++){
                if(i%j==0){
                    long big = i/j;
                    
                    if(big<=10000000){
                        max = big;
                        break;
                    }
                    
                    max = j;
                }
            }
            answer[idx++] = max;
        }
        return answer;
    }
}