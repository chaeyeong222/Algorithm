
import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] num, cal;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp += cal[i];
            sb.append(num[i]+temp).append(' ');
        }
        System.out.println(sb);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        cal = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int depth = Integer.parseInt(st.nextToken());
            cal[start]+=depth;
            cal[end+1]-=depth;
        }
    }
}