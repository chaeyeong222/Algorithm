import java.util.*;
import java.io.*;
class Solution {
    public int[] dr={1,0,0,-1}; //d l r u 순서
    public int[] dc = {0,-1,1,0}; 
    char[] dir = {'d','l','r','u'};
    public String answer = ""; 
    public int n,m,R,C;
    public String solution(int n, int m, int x, int y, int r, int c, int k) { 
        this.n=n;
        this.m=m;
        R=r-1;
        C=c-1;
        escape(x-1,y-1,k,new StringBuilder());
        return answer.equals("")? answer ="impossible": answer;
    }
    public void escape(int nowR, int nowC, int remain, StringBuilder sb){ 
        if (!answer.equals("")) return; 
        int dist = Math.abs(nowR-R) + Math.abs(nowC-C); 
        if(dist > remain ||  (remain-dist)%2==1){//남은 이동거리가 부족하거나 홀수이면
            return;            
        } 
        if(remain==0){
            if(nowR == R && nowC ==C){//조건맞춤 
                answer = sb.toString();
            }
            return;
        }
        
        for(int i=0; i<4; i++){ 
            int nr = nowR + dr[i];
            int nc = nowC + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m ){ //범위안
                escape(nr, nc, remain-1, sb.append(dir[i]));
                sb.deleteCharAt(sb.length()-1);
                
                 if (!answer.equals("")) return; 
            }
        }
    }
}