import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};//시계방향
    static int[][] map;
    static int rows, columns;
    static int[] answer;
    static int[][] queries;
    static List<Integer> list;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        this.rows = rows;
        this.columns = columns;
        this.queries = queries;
        list = new ArrayList<>();
        map = new int[rows][columns];
        
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = num++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            changePosition(i, queries[i]);
        } 
        return answer; 
    }
    public void changePosition(int idx, int[] query){
        boolean[][] visited = new boolean[rows][columns];
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        int temp = map[x1][y1];
        int min = temp;
        for (int x = x1; x < x2; x++) {
            map[x][y1] = map[x + 1][y1];
            min = Math.min(min, map[x][y1]);
        }

        // 아래 가로
        for (int y = y1; y < y2; y++) {
            map[x2][y] = map[x2][y + 1];
            min = Math.min(min, map[x2][y]);
        }

        // 오른쪽 세로
        for (int x = x2; x > x1; x--) {
            map[x][y2] = map[x - 1][y2];
             min = Math.min(min, map[x][y2]);
        }

            // 위 가로
        for (int y = y2; y > y1 + 1; y--) {
            map[x1][y] = map[x1][y - 1];
            min = Math.min(min, map[x1][y]);
        }

        map[x1][y1 + 1] = temp;

         answer[idx] = min;
    }
} 