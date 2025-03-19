import java.io.*;
import java.util.*;

class Main {
    static int[] dist;
    static int[][] dp;
    static String word1, word2;
    static ArrayList<int[]>[] list ;
    public static void main(String[] args) throws Exception {
        set();
        pro(); 
    }
    public static void pro() {
        int max = 0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word1 = br.readLine();
        word2 = br.readLine();
        dp = new int[word1.length()+1][word2.length()+1];
    }
}
