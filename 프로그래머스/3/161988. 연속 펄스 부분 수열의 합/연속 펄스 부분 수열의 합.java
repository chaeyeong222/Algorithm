import java.util.*;
import java.io.*;

class Solution {
     public long solution(int[] sequence) {
        long max = 0;
        long min = 0;
        long sum = 0;

        for (int i = 0; i < sequence.length; i++) {
            sum += (long) (sequence[i] * (i % 2 == 0 ? 1 : -1));
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        return Math.abs(max - min); 
     }
}