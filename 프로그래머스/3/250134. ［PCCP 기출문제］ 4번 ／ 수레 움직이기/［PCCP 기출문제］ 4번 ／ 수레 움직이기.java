import java.util.*;
import java.io.*;
class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1}; 
    int n,m;
    int redStartR, redStartC,redEndR, redEndC, blueStartR, blueStartC, blueEndR, blueEndC;
    int[][] maze; 
    int answer;
    Set<String> set = new HashSet<>();
    boolean[][] visitedR;
    boolean[][] visitedB;
    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;
        answer = n*m;
        visitedR = new boolean[n][m];
        visitedB = new boolean[n][m];
        getPosition();
        visitedR[redStartR][redStartC] = true;
        visitedB[blueStartR][blueStartC] = true;
        dfs(redStartR, redStartC, blueStartR, blueStartC, 0);
        
        if(answer == n*m) return 0;
        return answer;
    }
    public void dfs(int redR, int redC, int blueR, int blueC, int depth){  
        if(redR == redEndR && redC==redEndC && blueR == blueEndR && blueC == blueEndC){
            answer = Math.min(depth, answer);
            return;
        }
        if(depth>=answer) return;
        
        for(int i=0; i<4; i++){
            int nr;
            int nc;
            if(redR == redEndR && redC == redEndC){
                nr = redEndR;
                nc = redEndC;
            }else{
                nr = redR + dr[i];
                nc = redC + dc[i];
            }
            
            if(!rangeCheck(nr, nc) || maze[nr][nc]==5) continue;
            
            for(int j=0; j<4; j++){
                int bnr;
                int bnc;
                if(blueR == blueEndR && blueC == blueEndC){
                    bnr = blueEndR;
                    bnc = blueEndC;
                }else{
                    bnr = blueR + dr[j];
                    bnc = blueC + dc[j];
                }
                
                if(!rangeCheck(bnr, bnc) || maze[bnr][bnc]==5) continue;
                
                if(nr==bnr && nc ==bnc) continue;//같은칸
                if(nr==blueR && nc==blueC && bnr==redR && bnc==redC) continue; //교차
                if(!(nr==redEndR && nc == redEndC) && visitedR[nr][nc]) continue; //방문
                if(!(bnr==blueEndR && bnc ==blueEndC) && visitedB[bnr][bnc]) continue; //방문
                
                visitedR[nr][nc] = true;
                visitedB[bnr][bnc] = true;
                dfs(nr,nc,bnr,bnc,depth+1);
                visitedR[nr][nc] = false;
                visitedB[bnr][bnc] = false; 
            }
        }
        
        
    }
    public boolean rangeCheck(int r, int c){
        if(r>=0&& c>=0&& r<n && c<m) return true;
        return false;
    }
    
    public void getPosition(){ //각자의 출발도착위치 확인
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j]==1){
                    redStartR = i;
                    redStartC = j;
                }else if(maze[i][j]==2){
                    blueStartR = i;
                    blueStartC = j;
                }else if(maze[i][j]==3){
                    redEndR = i;
                    redEndC = j;
                }else if(maze[i][j]==4){
                    blueEndR = i;
                    blueEndC = j;
                }
            }
        }
    }
}
class State{
    int redR;
    int redC;
    int blueR;
    int blueC;
    int visitedR;
    int visitedB;
    int depth;
    public State(int redR, int redC,int blueR, int blueC, int visitedR, int visitedB, int depth){
        this.redR = redR;
        this.redC = redC;
        this.blueR = blueR;
        this.blueC = blueC;
        this.visitedR = visitedR;
        this.visitedB = visitedB;
        this.depth = depth;
    } 
} 