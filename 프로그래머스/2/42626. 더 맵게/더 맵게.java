import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] scoville, int K) { 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.offer(scov);
        }
        int cnt = 0;
        boolean flag = false;
        while (pq.size() > 1 && pq.peek() < K) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int mix = num1 + (num2 * 2);
            pq.offer(mix);
            cnt++;
        }
        return pq.peek() >= K ? cnt : -1;
    }
}