import java.io.*;
import java.util.*;

public class Main {
    static int N, score, P;
    static int[] num;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){

        if(N==0) {
            System.out.println(1);
            return;
        }
        if(N==P && num[N-1]>=score) {
            System.out.println(-1);
            return;
        }
        int pivot = 0;
        for (int i = 0; i < N; i++) {
            if(num[i]>score) {
                pivot++;
            }else {
                break;
            }
        }
        System.out.println(pivot+1);


    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        num = new int[N];
        if(N==0) return;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}