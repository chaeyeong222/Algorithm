import java.io.*;
import java.util.*;

class Main {
    static int N,M,H;
    static List<Integer>[] list;
    static int[][] dp;
    static int answer;

    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        for(int temp : list[0]){
            dp[0][temp]++;
        }


        for (int student = 1; student < N; student++) {
            for (int i = 0; i <= H ; i++) {
                for(int block : list[student]){
                    if(block==i) dp[student][i]++;
                    if(block < i) dp[student][i] += dp[student-1][i-block];
                }
                dp[student][i] += dp[student-1][i];
                dp[student][i]%=10007;
            }
        }
        System.out.println(dp[N-1][H]);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        dp = new int[N][H+1];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for(String tt : temp){
                list[i].add(Integer.parseInt(tt));
            }
        }
    }
}