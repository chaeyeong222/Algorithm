import java.io.*;
import java.util.*;

class Main {
    static int N, M, sum;
    static int[][] price;
    static int lowPSet; //6개씩 구매시 가장 낮은 가격
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        int need = N;
        if(need>=6){
            //패키지와 함께 비교
            int set = need/6;
            sum += (lowPSet*set);
            need -=(6*set);
        }
        //개별 가격확인
        int[] temp = new int[M];
        int lowPEach = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
           temp[i] = price[i][0] * need;
           lowPEach = Math.min(temp[i], lowPEach);
        }
        lowPEach = Math.min(lowPEach, lowPSet);
        sum +=lowPEach;
        System.out.println(sum);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lowPSet = Integer.MAX_VALUE;
        price = new int[M][2];
        for (int i = 0; i < M ; i++) {
            st =  new StringTokenizer(br.readLine());
            lowPSet = Math.min(lowPSet, Integer.parseInt(st.nextToken()));
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = price[i][0]*6;
            lowPSet = Math.min(lowPSet, price[i][1]);
        }
    }
}