import java.io.*;
import java.util.*;
//##1965 상자넣기
class Main {
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] box = new int[n];
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(box[j] < box[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}