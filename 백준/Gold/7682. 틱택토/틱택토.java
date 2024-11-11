
import java.io.*;
import java.util.*;
//##
class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(!word.equals("end")){
            map = new char[3][3];
            int xCnt = 0;
            int oCnt = 0;
            int dotCnt = 0;
            for (int i = 0; i < 9; i++) {
                map[i/3][i%3] = word.charAt(i);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(map[i][j]=='X') xCnt++;
                    else if(map[i][j]=='O') oCnt++;
                    else dotCnt++;
                }
            }

            if(xCnt-oCnt!=0  && xCnt-oCnt!=1){ sb.append("invalid").append('\n');}
            else if(xCnt-oCnt==1 && checkMap('O')){ //o가 끝나면 안됨
               sb.append("invalid").append('\n');
            }else if(xCnt-oCnt==0 && checkMap('X')){
                sb.append("invalid").append('\n');
            }else if(!checkMap('X') && !checkMap('O') && dotCnt!=0){ sb.append("invalid").append('\n');}
            else{ sb.append("valid").append('\n');}


            word = br.readLine();
        }//
        System.out.println(sb);
    }//
    public static boolean checkMap(char pivot){
        //가로
        for(int i=0; i<3; i++){
            if(map[0][i]==pivot && map[1][i]==pivot && map[2][i]==pivot) return true;
        }
        //세로
        for(int i=0; i<3; i++){
            if(map[i][0]==pivot && map[i][1]==pivot && map[i][2]==pivot) return true;
        }
        //대각선
        if(map[0][2]==pivot && map[1][1]==pivot && map[2][0]==pivot) return true;
        if(map[0][0]==pivot && map[1][1]==pivot && map[2][2]==pivot) return true;

        return false;
    }
}