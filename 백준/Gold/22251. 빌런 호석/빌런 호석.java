import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N,K,cnt,real;
    static int[][] diff;
    static int[][] num = {
            {1,1,1,1,1,1,0}, // 0
            {0,1,1,0,0,0,0}, // 1
            {1,1,0,1,1,0,1}, // 2
            {1,1,1,1,0,0,1}, // 3
            {0,1,1,0,0,1,1}, // 4
            {1,0,1,1,0,1,1}, // 5
            {1,0,1,1,1,1,1}, // 6
            {1,1,1,0,0,0,0}, // 7
            {1,1,1,1,1,1,1}, // 8
            {1,1,1,1,0,1,1}  // 9
    };
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        findDiff();
        changeNum();
        System.out.println(answer);
    }
    public static void changeNum(){
        String s = String.format("%0"+K+"d", real);

        for (int i = 1; i <= N; i++) {
            if(i==real) continue;

            String number = String.format("%0"+K+"d", i);
            
            int led = 0;
            for (int j = 0; j < K; j++) {
                int a = s.charAt(j)-'0';
                int b = number.charAt(j)-'0';
                led += diff[a][b];
            }
            if(led>=1 && led<= cnt) answer++;
        }
    }
    public static void findDiff(){
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 10; j++) {
                int cnt = 0;
                for (int k = 0; k < 7; k++) {
                    if(num[i][k]!=num[j][k]){
                        cnt++;
                    }
                }
                diff[i][j] = cnt;
                diff[j][i] = cnt;
            }
        }
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());
        real = Integer.parseInt(st.nextToken());
        diff = new int[10][10];
    }
}