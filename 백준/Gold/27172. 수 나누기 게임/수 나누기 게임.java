import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static int[] pos;
    static int[] score;
    public static void main(String[] args) throws IOException {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(score[i]).append(' ');
        }
        System.out.println(sb);
    }
    public static void pro(){
        int MAX = 1000000;
        for (int i = 0; i < N; i++) {
            int number = num[i];
            for (int j = number*2; j <= MAX; j+=number) {
                if(pos[j]!=-1){
                    score[i]++;
                    score[pos[j]]--;
                }
            }
        }
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N] ;
        score = new int[N] ;
        pos = new int[1000001] ;
        Arrays.fill(pos, -1);
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            pos[num[i]] = i;
        }
    }
}