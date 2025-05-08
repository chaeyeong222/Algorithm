import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] price, distance;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int nowPrice = price[0];
        int sum = nowPrice * distance[0];
        for (int i = 1; i < N-1; i++) {
            nowPrice = Math.min(nowPrice, price[i]);
            sum += (nowPrice*distance[i]);
        }
        System.out.println(sum);
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        distance = new int[N-1];
        price = new int[N];
        for (int i = 0; i < N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
    }
}