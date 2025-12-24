import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] heavier;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        heavier = new int[N+1][N+1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            heavier[a][b] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(heavier[i][k]==1 && heavier[k][j]==1){
                        heavier[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if(i==j) continue;
                if(heavier[i][j]==1 || heavier[j][i]==1) cnt++;
            }
            sb.append(N-cnt-1).append('\n');
        }
        System.out.println(sb);
    }
}