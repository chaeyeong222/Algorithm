import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb;
    static int[][] num, sum;
    static int N, M ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N+1][N+1];
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum = new int[N+1][N+1];
        sum[1][1] = num[1][1];
        for (int i = 2; i <= N; i++) {
            sum[1][i] = sum[1][i-1]+num[1][i];
            sum[i][1] = sum[i-1][1]+num[i][1];
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j]-sum[i-1][j-1] +  num[i][j];
            }
        }
        for (int TC = 0; TC < M; TC++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            sb.append(getSum(r1,c1,r2,c2)).append('\n');
        }
        System.out.println(sb);
    }
    public static int getSum(int r1, int c1, int r2, int c2){
        return sum[r2][c2]-sum[r1-1][c2]-sum[r2][c1-1]+sum[r1-1][c1-1];
    }
}