import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[][] house;
    static int[][] sum;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        sum[0][0] = house[0][0];
        sum[0][1] = house[0][1];
        sum[0][2] = house[0][2];
        for (int i = 1; i < N; i++) {
            sum[i][0] = Math.min(sum[i-1][1],sum[i-1][2])+house[i][0];
            sum[i][1] = Math.min(sum[i-1][0],sum[i-1][2])+house[i][1];
            sum[i][2] = Math.min(sum[i-1][1],sum[i-1][0])+house[i][2];
        }
        System.out.println(Math.min(Math.min(sum[N-1][0], sum[N-1][1]),sum[N-1][2]));
    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        house = new int[N][3];
        sum = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}