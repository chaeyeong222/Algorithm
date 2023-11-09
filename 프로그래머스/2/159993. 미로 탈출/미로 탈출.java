import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] map;
    public int solution(String[] maps) {
        int answer = 0; 
        map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        
        int[] check1 = findStartPoint('S');
        int cnt1 = bfs(check1[0], check1[1], 'L');
        if(cnt1==-1) return -1;
        int[] check2 = findStartPoint('L');
        int cnt2 = bfs(check2[0], check2[1], 'E');
        if(cnt2==-1) return -1;
        
        return cnt1 + cnt2; 
    }
    //최소 거리 찾는 메서드
    public int bfs(int x, int y, char target){
        
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue< Node > que = new LinkedList<>();
        que.offer(new Node(x,y,0));
        visited[x][y] = true; 
        
        while(!que.isEmpty()){
            Node node = que.poll(); 
            
            int r = node.r;
            int c = node.c;
            
            for(int i=0; i<4; i++){
                int nowR = r+dr[i];
                int nowC = c+dc[i];
                
                if(nowR>=0 && nowC>=0 && nowR<map.length && nowC < map[0].length && !visited[nowR][nowC]){
                    //찾는값이면 끝
                    if(map[nowR][nowC]==target) return node.level+1;
                    if(map[nowR][nowC]=='O' || map[nowR][nowC]=='E' || map[nowR][nowC]=='L' || map[nowR][nowC]=='S') {
                    visited[nowR][nowC] = true; 
                    que.offer(new Node(nowR, nowC, node.level+1)); 
                    } 
                }
            }  
        }//while 
        return -1; 
    }
    
    // 출발지 좌표를 찾는 메서드
    public int[] findStartPoint(char start){
        int[] startpoint = new int[2];
        out: for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]==start) {
                    startpoint[0]=i;
                    startpoint[1]=j;
                    break out;
                }
            }
        }
        return startpoint;
    }
}

class Node{ 
    int r;
    int c;
    int level;
    public Node(int r, int c, int level){
        this.level = level;
        this.r = r;
        this.c = c;
    }
}