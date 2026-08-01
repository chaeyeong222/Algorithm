import java.util.*;
class Solution {
    public Integer[] p = new Integer[100001];
    public int solution(int n) {
        int answer = 0;
        p[0] = 0;
        p[1] = 1;
        pivo(n);
        return p[n];
        
    }
    public int pivo(int n){
        if(p[n]==null){
            return p[n] = (pivo(n-1)+pivo(n-2))%1234567;
        }
        return p[n]%1234567;
        
    }
}