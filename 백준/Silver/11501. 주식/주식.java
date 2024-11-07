
import java.io.*;
import java.util.*;
//## 11501
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            int max = num[n-1];

            long sum = 0;
            for (int i = n-2; i >=0 ; i--) {
                if(num[i] <= max){
                    sum+= (max-num[i]);
                }else if(num[i]>max){
                    max = num[i];
                }
            }
            sb.append(sum).append('\n');

        }
        System.out.println(sb);
    }
}