import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int[] dp_keep = new int[N];
        int[] dp_remove = new int[N];
        dp_keep[0] = num[0];
        dp_remove[0] = -1000000000;
        int max = num[0];
        for (int i = 1; i < N; i++) {
            dp_keep[i] = Math.max(dp_keep[i-1]+num[i], num[i]);
            dp_remove[i] = Math.max(dp_remove[i-1]+num[i], dp_keep[i-1]);

            max = Math.max( Math.max(max, dp_keep[i]), dp_remove[i]); 
        }
        System.out.println(max);


    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}