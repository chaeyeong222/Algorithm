
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K;
    static int[][] stars;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){

        int answer = 0;
        for (int i = 0; i < K; i++) {
            for (int w = 0; w < K; w++) {
                int startR = stars[i][0]; //시작점
                int startC = stars[w][1];

                int cnt = 0;
                for (int j = 0; j < K; j++) {
                    int rr = stars[j][0];
                    int cc = stars[j][1];
                    if (startR <= rr && rr <= startR + L && startC <= cc && cc <= startC + L) {
                        cnt++;
                    }

                }
                answer = Math.max(answer, cnt);
            }
        }
        System.out.println(K-answer);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stars = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            stars[i][0] = r;
            stars[i][1] = c;
        }
    }
}