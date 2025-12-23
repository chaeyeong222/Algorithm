import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] num;
    static long total;
    static long answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        long start = 1;
        long end = 1000000000;
        while (start<=end){
            long mid = (start+end)/2;
            if(check(mid)){
                answer = Math.min(answer, total-mid*M);
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
    public static boolean check(long pivot){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += (num[i]/pivot);
        }
        if(cnt>=M) return true;
        return false;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            total+=num[i];
        }
        answer = Long.MAX_VALUE;
    }
}