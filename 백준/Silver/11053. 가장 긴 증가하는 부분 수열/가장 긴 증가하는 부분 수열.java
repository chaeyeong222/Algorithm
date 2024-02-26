import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if( nums[j] < nums[i] && dp[j]+1 > dp[i] ){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max); 
    }
}