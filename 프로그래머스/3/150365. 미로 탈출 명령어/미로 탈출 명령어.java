import java.util.*;
import java.io.*;
class Solution {
    public int[] dr={1,0,0,-1}; //d l r u 순서
    public int[] dc = {0,-1,1,0}; 
    public String answer = ""; 
    public int n,m,R,C;
    public String solution(int n, int m, int x, int y, int r, int c, int k) { 
        this.n=n;
        this.m=m;
        R=r-1;
        C=c-1;
        escape(x-1,y-1,0,k,new StringBuilder());
        if(answer.equals("")) return "impossible";
        else return answer;
    }
    public void escape(int nowR, int nowC, int cnt, int k, StringBuilder sb){ 
        if (!answer.equals("")) return;
        if(sb.length()>k) return;//개수초과시 종료
        if(sb.length()==k){
            if(nowR == R && nowC ==C){//조건맞춤 
                compare(answer, sb.toString()); 
            }
            return;
        }
        int dist = Math.abs(nowR-R) + Math.abs(nowC-C);
        int remain = k-sb.length();
        if(dist > remain ||  (remain-dist)%2==1){//남은 이동거리가 부족하거나 홀수이면
            return;            
        } 
        for(int i=0; i<4; i++){ 
            int nr = nowR + dr[i];
            int nc = nowC + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m ){ //범위안
                if(i==0){   
                    escape(nr, nc, cnt+1, k, new StringBuilder(sb).append('d'));
                }else if(i==1){ 
                    escape(nr, nc, cnt+1, k,  new StringBuilder(sb).append('l'));
                }else if(i==2){
                    escape(nr, nc, cnt+1, k, new StringBuilder(sb).append('r'));
                }else if(i==3){
                    escape(nr, nc, cnt+1, k,  new StringBuilder(sb).append('u'));
                }
            }
        }
    }
    public void compare(String a, String b){
        if (answer.equals("") || b.compareTo(answer) < 0) answer = b;
        return;
    }
}