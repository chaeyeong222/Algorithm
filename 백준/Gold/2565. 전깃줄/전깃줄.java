import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[][] line;
    static int cnt, cnt2;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        Arrays.sort(line, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        int max = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(line[i][1] > line[j][1] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N-max);
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

    }
}