import java.io.*;
import java.util.*;
//##19637
class Main {
    static int[] power;
    static String[] name;
    static int n,m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        name = new String[n];
        power = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            check(Integer.parseInt(br.readLine()));
        }
        System.out.println(sb);

    }
    public static void check(int num){
        int start = 0;
        int end = n-1;

        int answer = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(num<=power[mid]){
                answer = Math.min(mid, answer);
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        sb.append(name[answer]).append('\n');

    }
}