import java.util.*;
import java.io.*;

class Solution {
    static int maxSizeOfOneArea;
    static int numberOfArea;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        
        for(int i= 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    checkArea(i,j,picture, m,n);
                }
            }
        }
        int[] answer = new int[2]; 
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        
        
        return answer;
    }
    public void checkArea(int r, int c, int[][] picture,int m, int n){
        numberOfArea++;
        visited[r][c] = true;
        int pivot = picture[r][c];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        int cnt = 1;
        while(!que.isEmpty()){
            int[] now = que.poll();
            for(int i=0; i<4; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && picture[nr][nc]==pivot && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    cnt++;
                    que.offer(new int[]{nr,nc});
                }
            }
        }//while
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }
}