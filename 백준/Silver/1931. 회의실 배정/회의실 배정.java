import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] time = new int[n][2]; //시작, 끝
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            time[i][0] = num1;
            time[i][1] = num2;
        }
        //시간차를 기준으로 오름차순 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prev_end = 0;
        for (int i = 0; i < n; i++) {
            if(prev_end<=time[i][0]){
                cnt++;
                prev_end = time[i][1];
            }
        }
        System.out.println(cnt);


    }
}
