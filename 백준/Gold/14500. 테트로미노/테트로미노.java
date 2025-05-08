import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static int[][] map;
    static int answer;
    static int[][][] tetrominoes = {
            // I
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}},
            // O
            {{0,0},{0,1},{1,0},{1,1}},
            // L
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,1},{1,1},{2,1},{2,0}},
            {{0,0},{0,1},{1,0},{2,0}},
            {{0,0},{0,1},{1,1},{2,1}},
            {{0,0},{0,1},{0,2},{1,0}},
            {{0,0},{0,1},{0,2},{1,2}},
            {{0,2},{1,0},{1,1},{1,2}},
            {{0,0},{1,0},{1,1},{1,2}},
            // Z
            {{0,0},{0,1},{1,1},{1,2}}, // z
            {{1,0},{1,1},{0,1},{0,2}}, // s
            {{0,1},{1,0},{1,1},{2,0}}, // z 회전
            {{0,0},{1,0},{1,1},{2,1}}, // s 회전
            // T
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,1},{1,0},{1,1},{2,1}},
            {{1,0},{1,1},{1,2},{0,1}},
            {{0,0},{1,0},{1,1},{2,0}},
    };

    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for(int[][] shape : tetrominoes){
                    int sum = 0;
                    boolean flag = true;

                    for(int[] d : shape){
                        int nr = i+d[0];
                        int nc = j+d[1];
                        if(nr<0 || nc<0|| nr>=R || nc>= C){
                            flag = false;
                            break;
                        }
                        sum += map[nr][nc];
                    }
                    if(flag) answer = Math.max(sum, answer);
                }
            }
        }
        System.out.println(answer);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}