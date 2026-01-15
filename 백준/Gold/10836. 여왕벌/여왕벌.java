import java.io.*;
import java.util.*;

public class Main {
    static int N,M, L;
    static int[][] map;
    static int[] borderGrwoth;
    static int[] diff;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(' ');
            }sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void pro(){
        int acc = 0;
        for (int i = 0; i < L; i++) {
            acc += diff[i];
            borderGrwoth[i] = acc;
        }

        for (int i = M-1; i >=0 ; i--) {
            int idx = M-1-i;
            map[i][0] += borderGrwoth[idx];
        } 
        for (int i = 1; i < M; i++) {
            map[0][i] += borderGrwoth[M-1+i];
        }

        //내부채우기
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                map[i][j] = Math.max(map[i-1][j],map[i][j-1]);
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][M];
        L = 2*M-1;
        borderGrwoth = new int[L];
        diff = new int[L+1];
        for (int i = 0; i < M; i++) {
            Arrays.fill(map[i], 1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            diff[zero]+=1;
            diff[zero+one]+=1;
        }
    }
}