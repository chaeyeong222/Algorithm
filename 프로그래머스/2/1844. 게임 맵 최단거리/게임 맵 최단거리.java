import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length]; 
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0,1});//행,열,이동거리
        visited[0][0] = true;
        int[] now = new int[3];
        int minLength = 10000;
        while(!que.isEmpty()){
            now = que.poll();
            //상하좌우 탐색
            for(int i=0;i<4;i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                //범위안에 있고, 벽이 아니고, 방문하지 않았다면
                if(nr<maps.length && nr>=0 && nc>=0 && nc<maps[0].length && maps[nr][nc]==1 && !visited[nr][nc]){
                    //방문처리
                    visited[nr][nc] = true;
                    //만약 상대진영에 도착했다면 끝
                    if(nr==maps.length-1 && nc==maps[0].length-1){
                        minLength = Math.min(minLength, now[2]+1);
                    }
                    que.offer(new int[]{nr,nc,now[2]+1});
                }
            }
        }
        if(minLength!=10000){
            answer = minLength;
        }else answer = -1;
        return answer;
    }
}