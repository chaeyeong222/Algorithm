import javax.swing.plaf.ProgressBarUI;
import java.io.*;
import java.util.*;
//##
class Main {
    static int N,M;
    static int[] num;
    static int cnt;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    static void pro(){
        long sum = 0;
        int left = 0;
        int right = 0;

        while(right<=N){
            if(sum >= M){
                sum -= num[left++];
            }else{
                sum += num[right++];
            }
            if(sum==M) cnt++; //목적도달하면 cnt++)
        }

        System.out.println(cnt);
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
    }
}