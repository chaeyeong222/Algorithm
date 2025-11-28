import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] poss;
    static int[] arr;
    static int maxCnt, needG;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        poss = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 기타 이름 버림
            poss[i] = st.nextToken().toCharArray();
        }

        for (int i = 1; i <= N; i++) {
            arr = new int[i];
            combi(0,0,i);
        }

        if(maxCnt==0){
            System.out.println(-1);
        }else{
            System.out.println(needG);
        }
    }

    static void combi(int depth, int start, int max) {
        if(maxCnt==M) return;
        if (depth == max) {
            boolean[] song = new boolean[M];

            for (int idx : arr) {
                for (int i = 0; i < M; i++) {
                    if (poss[idx][i] == 'Y') song[i] = true;
                }
            }

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (song[i]){
                    cnt++;
                }
                if(cnt>maxCnt){
                    maxCnt = cnt;
                    needG = max;
                }
            }
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = i;
            combi(depth + 1, i + 1, max);
        }
    }
}
