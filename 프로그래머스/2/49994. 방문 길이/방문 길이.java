import java.util.*;
import java.io.*;

class Solution{
    public static int solution(String dirs) {
        int answer = 0;
        // 0U 1D 2L 3R
        boolean[][][] visited = new boolean[11][11][4];
        char[] direction = dirs.toCharArray();
        int nr = 5;
        int nc = 5;
        for(int i=0; i<dirs.length(); i++){
            if(direction[i]=='U' && nr-1 >= 0){
                if(!visited[nr-1][nc][1] && !visited[nr][nc][0]) {
                    visited[nr-1][nc][1] = true;
                    visited[nr][nc][0] = true;
                    answer++;
                }
                nr-=1;
            }else if(direction[i]=='D' && nr+1 <= 10){
                if( !visited[nr+1][nc][0] && !visited[nr][nc][1]){
                    answer++;
                    visited[nr+1][nc][0] = true;
                    visited[nr][nc][1] = true;
                }
                nr+=1;
            }else if(direction[i]=='L' && nc-1 >=0 ){
                if(!visited[nr][nc-1][3] && !visited[nr][nc][2]){
                    answer++;
                    visited[nr][nc-1][3] = true;
                    visited[nr][nc][2] = true;
                }
                nc-=1;
            }else if(direction[i]=='R' && nc+1 <= 10  ){
                if(!visited[nr][nc+1][2] && !visited[nr][nc][3]){
                    answer++;
                    visited[nr][nc+1][2] = true;
                    visited[nr][nc][3] = true;
                }
                nc+=1;
            }
        }

        return answer;
    }
}
