import java.io.*;
import java.util.*;
class Main {
    static int N, K;
    static int[] wine;
    static long sum;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        Arrays.sort(wine);
        sum+=wine[N-1];
        K--;
        int maxIdx = N-2;
        int minIdx = 0;
        while(K>1){
            sum += (wine[maxIdx--] - wine[minIdx++]);
            K-=2;
        }
        System.out.println(sum);

    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wine = new int[N];
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(st.nextToken());
        }
        sum = 0;

    }
}