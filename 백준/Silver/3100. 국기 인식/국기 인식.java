import java.io.*;
import java.util.*;
class Main {
    static char[][] board;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        //가로구분
        int garo = garoCheck();
        //세로구분
        int sero = seroCheck();
        System.out.println(Math.min(garo, sero));
    }
    public static int garoCheck( ){
        int min = Integer.MAX_VALUE;
        for (char  c1 = 'A'; c1 <='Z'; c1++) {
            for (char  c2 = 'A'; c2 <= 'Z'; c2++) {
                for (char  c3 = 'A'; c3 <= 'Z'; c3++) {
                    if(c1==c2 || c2==c3) continue;
                    int cnt = 0;
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(board[i][j]!=c1) cnt++;
                        }
                    }
                    for (int i = 2; i < 4; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(board[i][j]!=c2) cnt++;
                        }
                    }
                    for (int i = 4; i < 6; i++) {
                        for (int j = 0; j < 9; j++) {
                            if(board[i][j]!=c3) cnt++;
                        }
                    }
                    min = Math.min(min, cnt);
                }
            }
        }
        return min;
    }
    public static int seroCheck(){
        int min = Integer.MAX_VALUE;
        for (char c1 = 'A'; c1 <='Z'; c1++) {
            for (char c2 = 'A'; c2 <= 'Z'; c2++) {
                for (char c3 = 'A'; c3 <= 'Z'; c3++) {
                    if(c1==c2 || c2==c3) continue;
                    int cnt = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 6; j++) {
                            if(board[j][i]!=c1) cnt++;
                        }
                    }
                    for (int i = 3; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            if(board[j][i]!=c2) cnt++;
                        }
                    }
                    for (int i = 6; i < 9; i++) {
                        for (int j = 0; j < 6; j++) {
                            if(board[j][i]!=c3) cnt++;
                        }
                    }
                    min = Math.min(min, cnt);
                }
            }
        }
        return min;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[6][9];
        for (int i = 0; i < 6; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }
}