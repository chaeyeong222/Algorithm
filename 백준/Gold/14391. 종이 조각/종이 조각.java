import javax.naming.NamingSecurityException;
import java.io.*;
import java.util.*;
class Main {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        int maxSum = 0;
        int totalIdx = N*M;

        for (int bitmask = 0; bitmask < (1<<totalIdx); bitmask++) {
            //가로
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int curr = 0;
                for (int j = 0; j < M; j++) {
                    int nowIdx = i * M + j;//현재 idx구하기
                    if((bitmask & (1<<nowIdx))==0){
                        curr = curr*10 + map[i][j];
                    }else {
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }
            //세로
            for (int j = 0; j < M; j++) {
                int curr = 0;
                for (int i = 0; i < N; i++) {
                    int nowIdx = i * M + j;
                    if((bitmask & (1<<nowIdx))!=0){
                        curr = curr*10+map[i][j];
                    }else{
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }
            maxSum = Math.max(sum, maxSum);
        }//for
        System.out.println(maxSum);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j)-'0';
            }
        }
    }
}