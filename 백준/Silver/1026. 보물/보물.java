import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] a,b;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (a[i]*b[N-i-1]);
        }
        System.out.println(sum);
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        b = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
    }
}