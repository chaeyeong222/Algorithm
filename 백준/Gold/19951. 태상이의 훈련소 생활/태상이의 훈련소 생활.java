
import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] num, cal, dp;
    static List<int[]> list;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp += cal[i];
            dp[i] = num[i]+temp;
            sb.append(dp[i]).append(' ');
        }
        System.out.println(sb);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        dp = new int[N];
        cal = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
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