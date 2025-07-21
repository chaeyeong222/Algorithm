import java.util.*;
import java.io.*;

class Solution { 
    static int[][] dp; 
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int N = elements.length ;
        int[] prefix = new int[N*2+1];
        
        for(int i= 0; i< N*2; i++){
            prefix[i+1] = prefix[i] + elements[i%N]; 
        } 
        
        for(int i=1; i<=N; i++){
            for(int j=0; j<N; j++){
                int sum = prefix[i+j] - prefix[j];
                set.add(sum);
            }
        } 
        return set.size();
    } 
}