import java.util.*;
import java.io.*;
class Solution {
    static int[] dr = {1, 0, -1};
    static int[] dc = {0, 1, -1};
    public int[] solution(int n)  {
        if(n==1) return new int[]{1};
        int[][] map = new int[n][n];
        int r = 0;
        int c = 0;
        int dir = 0;
        int num = 1;
        while(map[r][c]==0){
            map[r][c] = num++;
            int nr = r+dr[dir];
            int nc = c+dc[dir];
            if(nr>=n  || nc>=n  || map[nr][nc]!=0){
                dir = (dir + 1) % 3; 
                r += dr[dir];
                c += dc[dir];
            }else{
                r = nr;
                c = nc;
            }
        }
        
          return Arrays.stream(map)
                     .flatMapToInt(Arrays::stream)
                     .filter(i -> i != 0)
                     .toArray();
    }
}