import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[]  wine;
    static Integer[] result;
    public static void main(String[] args) throws Exception {
        set();

        pro();
        System.out.println(result[N]);
    }
    public static void pro( ){


        result[0] = 0;
        result[1] = wine[1];
        if(N>1){
            result[2] = wine[1] + wine[2];
        }
        for (int i = 3; i <= N; i++) {
            result[i] = Math.max( result[i-1], Math.max(result[i-2]+wine[i], result[i-3]+wine[i-1]+wine[i]));
        }

    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        wine = new int[N+1];
        result = new Integer[N+1];
        for (int i = 1; i < N+1; i++) {
            wine[i]  = Integer.parseInt(br.readLine());
        }

    }
}