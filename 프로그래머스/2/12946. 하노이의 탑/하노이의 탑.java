import java.util.*;
import java.io.*;
class Solution {
    List<int[]> list;
    int m=0;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n,1,3,2);
        int[][] answer = new int[m][2];
        for(int i=0; i<m; i++){
            answer[i] = list.get(i); 
        }
        return answer;
    }
    public void hanoi(int n, int from, int to, int via){
        if(n==1){
            m++;
            list.add(new int[]{from,to});
            return;
        }
        hanoi(n-1, from, via, to);
        m++;
        list.add(new int[]{from, to});
        hanoi(n-1, via, to, from);  
    }
}