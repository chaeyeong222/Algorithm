import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static long max, answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        long start = 1;
        long end = max;
        while(start<=end){
            long mid = (start+end)/2;
            if(binary(mid)){
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
    public static boolean binary(long pivot){
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            cnt += (num[i]+pivot -1)/pivot;
            if(cnt > N) return false;
        }
        return cnt <= N;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M];

        for (int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[i]);
        }
    }
}
