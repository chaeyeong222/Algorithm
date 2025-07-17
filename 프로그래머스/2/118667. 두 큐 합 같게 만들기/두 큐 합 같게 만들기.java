import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) { 
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for(int i=0; i<queue1.length; i++){
            que1.offer(queue1[i]);
            sum1+=queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            que2.offer(queue2[i]);
            sum2+=queue2[i];
        }
        long max = (long)(queue1.length + queue2.length)*2;
        long cnt = 0;
        while(cnt<=max){ 
            if(sum1==sum2){
                break;
            }else if(sum1<sum2){
                int temp = que2.poll();
                que1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
            }else{
                int temp = que1.poll();
                que2.offer(temp);
                sum2 += temp;
                sum1 -= temp;
            } 
            cnt++;
        }
        if(sum1==sum2 ) return cnt; 
        else return -1;
    }
}