import java.io.*;
import java.util.*;

public class Main {
    static long[] fact = new long[21];
    static boolean[] used = new boolean[21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        fact[0] = 1;
        for (int i = 1; i <= 20; i++) fact[i] = fact[i-1] * i;

        if (M == 1) {
            long K = Long.parseLong(st.nextToken());
            solveType1(N, K);
        } else {
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            solveType2(N, arr);
        }
    }
    static void solveType1(int N, long K) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int num = 1; num <= N; num++) {
                if (used[num]) continue;

                long cnt = fact[N - i];

                if (K > cnt) {
                    K -= cnt;
                } else {
                    sb.append(num).append(' ');
                    used[num] = true;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
    static void solveType2(int N, int[] arr) {
        long result = 1;

        for (int i = 0; i < N; i++) {
            for (int num = 1; num < arr[i]; num++) {
                if (!used[num]) {
                    result += fact[N - 1 - i];
                }
            }
            used[arr[i]] = true;
        }

        System.out.println(result);
    }
}
