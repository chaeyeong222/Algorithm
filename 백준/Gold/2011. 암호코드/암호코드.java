import java.io.*;
import java.util.*;
//##암호코드
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int[] num = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            num[i] = temp.charAt(i)-'0';
        }
        long[] dp = new long[5001];
        dp[0]=1;
        if(num[0]==0) dp[0]=0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < temp.length(); i++) {
            int check = num[i-1]*10 + num[i];
            if(check==0){ //예외1. 00이면 불가
                sb.append(0);
                break;
            }else if(check==10 || check==20){//예외2.10이나 20이면 가능하지만 추가x
                if(i==1){
                    dp[1] = 1;
                }else{
                    dp[i-1] = dp[i-2];
                    dp[i] = dp[i-2];
                }
            }else if(check%10==0){//예외3. 10의 배수이면 불가(10,20제외)
                sb.append(0);
                break;
            }else if(check<10){ //한자리수라면 이어서
                if(i==1) dp[1] = 0;
                else {
                    dp[i - 1] = dp[i - 2];
                    dp[i] = dp[i - 2];
                }
            }else if(check>26){ //26보다 크면 그대로
                dp[i] = dp[i-1];
            }else{ //
                if(i==1) dp[1] = 2;
                else dp[i] = (dp[i-1] + dp[i-2])%1000000;
            }
        }
        if(sb.length()>0) System.out.println(sb);
        else System.out.println(dp[temp.length()-1 %1000000]);
    }
}