import java.util.*;
import java.io.*;
class Solution {
    static int[][] q;
    static int m, n;
    static int[] ans;
    static List<Integer> arr;
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        m = ans.length;
        this.ans = ans;
        this.q = q;
        this.n = n;
        arr = new ArrayList<>();
        combination(1, new ArrayList<>());
        return answer;
    }
    public void combination(int start, List<Integer> list){
        if(list.size()==5){
            if(check(list)) answer++;
            return;
        }
        for(int i=start; i<=n; i++){
            list.add(i);
            combination(i+1, list);
            list.remove(list.size()-1);
        }  
    }
    public boolean check(List<Integer> list){
        for(int i=0; i<q.length; i++){
            int cnt = 0;
            for(int j = 0; j<5; j++){
                if(list.contains(q[i][j])){
                    cnt++;
                    if(cnt>ans[i]) return false; //이미 넘어버림
                }
            }//
            if(cnt<ans[i]) return false;
        } 
        return true;
    }
}