import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static long answer;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        long start = 0;
        long end = (long)1e18; 
        while(start<=end){
            long mid = (start+end)/2;
            if(check(mid)){
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
    public static boolean check(long mid){
        long peo = 0;
        for (int i = 0; i < N; i++) {
            peo += mid / num[i];
            if(peo >= M) return true; // 조기 종료
        }
        return false;
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
    }
}