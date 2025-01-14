import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[] card;
    static int[] sum;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                sum[i] = Math.max(sum[i], sum[i-j]+ card[j] );
            }
        }
        System.out.println(sum[N]);
    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[N+1];
        sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
    }
}