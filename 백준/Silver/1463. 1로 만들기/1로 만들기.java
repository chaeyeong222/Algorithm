import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer [] dp;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[1000001];
        dp[0]=dp[1]=0;
        System.out.println(recur(n));
    }
    public static int recur(int num){
        if(dp[num]==null){
            if(num % 6==0){
                dp[num] = Math.min(    recur(num-1),    Math.min(recur(num/2), recur(num/3))  )+1;
            }
            else if(num % 3==0){
                dp[num] = Math.min(recur(num/3), recur(num-1))+1;
            }else if(num % 2==0){
                dp[num] = Math.min(recur(num/2), recur(num-1))+1;
            }else{
                dp[num] = recur(num-1)+1;
            }
        }
        return dp[num];
    }
}
