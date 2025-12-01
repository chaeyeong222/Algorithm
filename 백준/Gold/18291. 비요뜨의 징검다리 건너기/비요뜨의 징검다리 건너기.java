import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static long answer, N;
    static int[] arr;
    static long MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-->0){
            N = Integer.parseInt(br.readLine());
            answer = 0;
            if(N==1) sb.append(1).append('\n');
            else if(N==2) sb.append(1).append('\n');
            else{
                answer = pow(2, N-2);
                sb.append(answer).append('\n');
            } 
        }
        System.out.println(sb);
    }
    public static long pow(long base, long exp){
         long result = 1;
         while(exp>0){
             if((exp&1)==1) result = (result*base)%MOD;
             base = (base*base) % MOD;
             exp>>=1;
         }
         return result;
    }
}
