import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] x;
    static long[] y;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += (x[i]*y[i+1]);
            sum2 += (y[i]*x[i+1]);
        }
        double answer = Math.abs(sum1-sum2)/2.0;
        System.out.printf("%.1f\n", answer);
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        x = new long[N+1];
        y = new long[N+1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken()); 
        }
        x[N] = x[0];
        y[N] = y[0];
    }
}
