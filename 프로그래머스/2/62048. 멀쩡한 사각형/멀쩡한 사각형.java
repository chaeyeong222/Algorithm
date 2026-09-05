import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        return (long)w*h-(w+h-gcd(w,h));
    }
    public long gcd(long a, long b){
        while(b!=0){
            long temp = a%b;
            a=b;
            b = temp;
        }
        return a;
    }
    
    
}