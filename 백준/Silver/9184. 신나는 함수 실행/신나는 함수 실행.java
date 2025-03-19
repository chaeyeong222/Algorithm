import java.io.*;
import java.util.*;
public class Main {
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        dp = new int[101][101][101]; //+50해서 생각~
        StringBuilder sb = new StringBuilder();
        while(true){
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1 ) break;
            int result = check(a,b,c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append('\n');
        }
        System.out.println(sb);
    }
    public static int check(int a, int b, int c){
        if(dp[a+50][b+50][c+50]!=0) return dp[a+50][b+50][c+50];
        if(a<=0 || b<=0 || c<=0) return dp[a+50][b+50][c+50]=1;
        if( a > 20 || b > 20 || c > 20) return dp[a+50][b+50][c+50] = check(20,20,20);
        if ( a < b && b < c ) return dp[a+50][b+50][c+50] =  check(a, b, c-1) + check(a, b-1, c-1) - check(a, b-1, c);
        else return dp[a+50][b+50][c+50] = check(a-1, b, c) + check(a-1, b-1, c) + check(a-1, b, c-1) - check(a-1, b-1, c-1);
    }
}