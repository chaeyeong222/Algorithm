import java.util.*;
import java.io.*;

class Solution {
    static char[][] map;
    public int solution(String[] board) {
        int answer = 1;
        int oCnt = 0;
        int xCnt = 0;
        map = new char[3][3];
        //옮겨담기
        for(int i=0; i<3; i++){
            map[i] = board[i].toCharArray();
        } 
        //카운트
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(  map[i][j]=='O'){
                    oCnt++;
                }else if( (map[i][j])=='X'){
                    xCnt++;
                }
            }
        }
        //순서 규칙안지킴
        if( oCnt-xCnt >=2 || xCnt>oCnt){
            return 0;
        }
        
        //
        if(checkBingo('O')){
            //O가 이미 빙곤데 x랑 개수 같으면 실수
            if(oCnt == xCnt) return 0; 
        }
           
        if(checkBingo('X')){
            //X 빙곤데 o가 x보다 1크면 실수
            if(oCnt > xCnt) return 0; 
        }
        
        return answer;
    }
    public static boolean checkBingo(char word){ 
        
        //가로
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == word
                    && map[i][1] == word
                    && map[i][2] == word) {
                return true;
            }
        }
        
        //세로
        
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == word && map[1][i] == word && map[2][i] == word) {
                return true;
            }
        } 
        //대각선 
        if (map[0][0] == word
                && map[1][1] == word
                && map[2][2] == word) {
            return true;
        } 
        if (map[2][0] == word
                && map[1][1] == word
                && map[0][2] == word) {
            return true;
        } 
        return false; 
    }
}