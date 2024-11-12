
import java.io.*;
import java.util.*;
//##
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(num[j]<num[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
 
        System.out.println(n-max);


    }
}