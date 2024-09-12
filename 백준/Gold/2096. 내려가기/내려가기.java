import java.io.*;
import java.util.*;
//##2096 내려가기
class Main {
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        int[][] num = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        } //입력
        
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        //첫째줄 채워주기
        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = num[0][i];
            minDp[0][i] = num[0][i];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0) {
                    maxDp[i][j] = Math.max( maxDp[i-1][j], maxDp[i-1][j+1])+num[i][j];
                    minDp[i][j] = Math.min( minDp[i-1][j], minDp[i-1][j+1])+num[i][j];
                }else if(j==2){
                    maxDp[i][j] = Math.max( maxDp[i-1][j], maxDp[i-1][j-1])+num[i][j];
                    minDp[i][j] = Math.min( minDp[i-1][j], minDp[i-1][j-1])+num[i][j];
                }else{
                    maxDp[i][j] = Math.max(Math.max( maxDp[i-1][j], maxDp[i-1][j-1]),maxDp[i-1][j+1]) +num[i][j];
                    minDp[i][j] = Math.min(Math.min( minDp[i-1][j], minDp[i-1][j-1]),minDp[i-1][j+1]) +num[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[n-1][i]);
            min = Math.min(min, minDp[n-1][i]);
        }
        System.out.println(max +" "+min);
        
        
    }
}