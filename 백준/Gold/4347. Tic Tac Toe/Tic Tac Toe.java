import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            map = new char[3][3];
            int xCnt = 0;
            int oCnt = 0;
            for (int i = 0; i < 3; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    if(map[i][j]=='X') xCnt++;
                    else if(map[i][j]=='O') oCnt++;
                }
            }
            if(TC!=T-1) br.readLine();//빈줄체크
            if(xCnt<oCnt || (xCnt-oCnt)>1){
                sb.append("no").append('\n');
                continue;
            }
            if(bingoCheck('X') && xCnt==oCnt){
                sb.append("no").append('\n');
                continue;
            }
            if(bingoCheck('O') && xCnt>oCnt){
                sb.append("no").append('\n');
                continue;
            }
            sb.append("yes").append('\n');
        }
        System.out.println(sb);
    }public static boolean bingoCheck(char pivot){
        //garo
        for (int i = 0; i < 3; i++) {
            if(map[i][0]==pivot && map[i][1]==pivot&& map[i][2]==pivot) return true;
        }
        //sero
        for (int i = 0; i < 3; i++) {
            if(map[0][i]==pivot && map[1][i]==pivot&& map[2][i]==pivot) return true;
        }
        //대각
        if(map[0][0]==pivot && map[1][1]==pivot&& map[2][2]==pivot) return true;
        if(map[2][0]==pivot && map[1][1]==pivot&& map[0][2]==pivot) return true;

        return false;
    }
}