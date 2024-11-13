import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st =new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[n];

        sum[0] = num[0];
        for (int i = 1; i < n; i++) {
            sum[i] = num[i] + sum[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s==e) {sb.append(num[s-1]).append('\n');}
            else if(s==1){
                sb.append(sum[e-1]).append('\n');
            }else{
                sb.append(sum[e-1]-sum[s-2]).append('\n');
            }
        }
        System.out.println(sb);



    }
}