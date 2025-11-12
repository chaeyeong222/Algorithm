import java.util.*;
import java.io.*;
class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;
        a--;
        b--;
        while(true){
            answer++;
            if((a/2)==(b/2) && Math.abs(a-b)==1){ //만남
                break;
            }
            if(a%2==1) a/=2;
            else a = (a+1)/2;
            
            if(b%2==1) b/=2;
            else b = (b+1)/2;
            
        }

        return answer;
    }
}