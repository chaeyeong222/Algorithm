

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long R, C;
    static long[][] num;
    static long answer;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        solve(0,0, 1<<N);
    }
    public static void solve(int r, int c, int size){
        if(size==1){
            System.out.println(answer);
            return;
        }
        int half = size/2;
        long area = (long) half * half;
        if(R<r+half && C<c+half){
            solve(r,c,half);
        }else if(R<r+half && C>=c+half){
            answer+=area;
            solve(r,c+half,half);
        }else if(R>=r+half && C<c+half){
            answer+=area*2;
            solve(r+half, c, half);
        }else{
            answer+=area*3;
            solve(r+half, c+half, half);
        }
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        num = new long[N][N];
    }
}