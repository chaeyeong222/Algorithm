
import javax.swing.*;
import java.io.*;
import java.util.*;
class Main {
    static int[][] position;
    static int answer, N;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int[] dist = new int[N-1];
        int sum = 0;
        for (int i = 1; i < N; i++) {
            dist[i-1] = Math.abs(position[i-1][0]-position[i][0])+Math.abs(position[i-1][1]-position[i][1]);
            sum += dist[i-1];
        }

        //체크포인트 체크
        int maxSkip = 0;
        for (int i = 1; i < N-1; i++) {
            int direcDist = Math.abs(position[i + 1][0] - position[i - 1][0]) + Math.abs(position[i + 1][1] - position[i - 1][1]);
            int skipDist = dist[i-1] + dist[i] - direcDist;
            maxSkip = Math.max(maxSkip, skipDist);
        }

        System.out.println(sum - maxSkip);

    }
    public static void set() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        position = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}