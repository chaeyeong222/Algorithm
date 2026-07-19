import java.util.*;
class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0,1});
        maps[0][0] = 2;
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(now[0]==n-1 && now[1]==m-1){
                answer = now[2];
                return answer;
            }
            for(int i=0; i<4; i++){
                int nr = now[0]+ dr[i];
                int nc = now[1]+ dc[i];
                if(nr>=0&& nr<n&& nc>=0 && nc<m && maps[nr][nc]==1){
                    maps[nr][nc] = 2;
                    que.offer(new int[]{nr, nc, now[2]+1});
                }
            }
        }
        return answer;
    }
}