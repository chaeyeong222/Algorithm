import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {0,0,1, -1}; 
    static int[] dc = {-1,1,0,0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (isValid(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
    public boolean isValid(String[] place){
        char[][] map = new char[5][5];
        for(int i=0; i<5; i++){
            map[i] = place[i].toCharArray();
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j]=='P'){
                    if (!checkDistance(map, i, j)){ return false;}
                }
            }
        }
        return true;
    }
    
    public boolean checkDistance(char[][]map, int r, int c){  
        Queue<Position> que = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        que.offer(new Position(r,c,0));
        visited[r][c]=true;
        
        while(!que.isEmpty()){
            Position now = que.poll();
            if(now.depth>=1 && now.depth<=2 && map[now.r][now.c]=='P'){
                return false;
            }
            if(now.depth==2) continue;
            for(int i=0; i<3; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr>=0 && nr<5 && nc>=0 && nc<5 && !visited[nr][nc] && map[nr][nc]!='X'){
                    visited[nr][nc] = true;
                    que.offer(new Position(nr,nc,now.depth+1)); 
                }
            }
        }//while
        return true;
    }
}
class Position{
    int r;
    int c;
    int depth;
    Position(int r, int c, int depth){
        this.r = r;
        this.c = c;
        this.depth = depth;
    }
} 