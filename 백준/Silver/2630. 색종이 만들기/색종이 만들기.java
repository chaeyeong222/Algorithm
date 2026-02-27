import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] num;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        rangeCheck(0,0, N,N);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    public static void rangeCheck(int startR, int startC, int endR, int endC){

        int pivot = num[startR][startC];
        if(startR==endR && startC==endC){
            answer[pivot]++;
            return;
        }

        boolean flag = true;
        out: for (int i = startR; i < endR; i++) {
            for (int j = startC; j < endC; j++) {
                if(num[i][j]!=pivot){
                    flag = false;
                    break out;
                }
            }
        }
        if(flag){
            answer[pivot]++;  //다 동일하면 그만
            return;
        } 
        int size = (endR-startR+1)/2; 
        rangeCheck(startR,startC,startR+size, startC+size);
        rangeCheck(startR+size,startC,endR, startC+size);
        rangeCheck(startR,startC+size,startR+size, endC);
        rangeCheck(startR+size,startC+size,endR, endC);
        

    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        answer = new int[2];
        num = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}