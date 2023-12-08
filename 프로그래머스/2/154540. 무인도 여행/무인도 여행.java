import java.util.*;
import java.io.*;

class Solution { 
    static int[][] trip;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n,m;
    public int[] solution(String[] maps) { 
        List<Integer> list = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        trip = new int[n][m];
        char[][] link = new char[n][m];
        for(int i=0; i<n; i++){
            maps[i] = maps[i].replace("X","0");  
            link[i] = maps[i].toCharArray(); 
        } 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                trip[i][j]= link[i][j]-'0';
            }
        }
        // System.out.println(trip[0][1]);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(trip[i][j]!=0){
                    list.add(bfs(i,j));
                }
            }
        }
        if(list.size()==0) return new int[]{-1};
        else {
            int[] answer = new int[list.size()]; 
            Collections.sort(list);
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
            
        return answer;
            
        } 
    }
    public int bfs(int r, int c){
        int days = 0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        days += trip[r][c];
        trip[r][c] = 0;
        while(!que.isEmpty()){
            int[] now = que.poll();
            for(int i=0; i<4; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && trip[nr][nc]!=0){
                    days+=trip[nr][nc];
                    trip[nr][nc]=0;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
        return days;
    }
    
}