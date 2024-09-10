import java.io.*;
import java.util.*;
//
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[n];

        int idx = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(cnt==num[i] && result[j]==0) {
                    result[j] = idx++;
                    break;
                }
                if(result[j]!=0) continue; //이미 자리 있으면 패스
                if(result[j]==0) cnt++; //없고, cnt 안채워졌으면 더해준다
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);




    }
}