import java.io.*;
import java.util.*;

class Main {
    static int N,K ;
    static int[]  map;
    static int ans;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(ans);
    }
    public static void pro(){
        int start = 1;
        int end = 1000000000;
        while(start<=end){
            int mid = (start+end)/2;
            if(check(mid)){
                ans = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
    }
    public static boolean check(int limit){
        boolean[] available = new boolean[N];
        for (int i = 0; i < N; i++) {
            available[i] = map[i] <= limit;
        }
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if(available[i]) cnt++;
        }
        if (cnt == 0) return false;
        for (int i = K; i < N; i++) {
            if (available[i - K]) cnt--;
            if (available[i]) cnt++;
            if (cnt == 0) return false;
        }
        return true;

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new int[N];
        for (int i = 0; i < N; i++) {
           map[i] = Integer.parseInt(st.nextToken());
        }
        ans = Integer.MAX_VALUE;

    }
}