import java.util.*;
import java.io.*;

class Solution{
    public int solution(int []A, int []B){
        int length = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for(int i=0; i<length; i++){
            answer += (A[i] *  B[length-i-1]);
        }
        

        return answer;
    }
}