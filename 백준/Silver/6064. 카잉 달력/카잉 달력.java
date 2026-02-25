import java.io.*;
import java.util.*;

public class Main {
    static int M, N, X, Y;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            int g = gcd(M,N);
            if((X-Y) % g !=0){
                sb.append(-1).append('\n');
                continue;
            }
            int lcm = M * N /g;
            int k = X;

            boolean found = false;

            while(k<=lcm){
                if((k-Y) %N==0){
                    sb.append(k).append('\n');
                    found= true;
                    break;
                }
                k+=M;
            }
            if(!found) sb.append(-1).append('\n');

        }
        System.out.println(sb);
    }
    public static boolean possible(int x, int y){
        if((x-y)%gcd(M,N)==0) return true;
        return false;
    }
    public static int gcd(int x, int y){
        while(y!=0){
            int temp = x%y;
            x = y;
            y = temp;
        }
        return x;
    }
}