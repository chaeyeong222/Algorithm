
import java.io.*;
import java.util.*;

public class Main{
    static int N, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            N = Integer.parseInt(br.readLine());
            int[][] people = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                people[i][0] = Integer.parseInt(st.nextToken());
                people[i][1] = Integer.parseInt(st.nextToken());
            }

            //정렬
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            //확인
            int cnt = 1;
            int nowLevel = people[0][1];
            for (int i = 1; i < N; i++) {
                if(people[i][1] < nowLevel) cnt++;
                nowLevel = Math.min(people[i][1], nowLevel);
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}