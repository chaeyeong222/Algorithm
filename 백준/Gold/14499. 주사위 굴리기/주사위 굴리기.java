
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, C, K;
    static int[] position, orders;
    static int[][] num;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if(rangeCheck(R,C, orders[i])){
                move(orders[i]);
                sb.append(position[0]).append('\n');
            }
        }
        System.out.println(sb);
    }
    public static void move(int o){
        //1동2서3북4남
        if(o==1){
            int temp = position[0];
            position[0] = position[4];
            position[4] = position[1];
            position[1] = position[5];
            position[5] = temp;
        }else if(o==2){
            int temp = position[0];
            position[0] = position[5];
            position[5] = position[1];
            position[1] = position[4];
            position[4] = temp;
        }else if(o==3){
            int temp = position[0];
            position[0] = position[3];
            position[3] = position[1];
            position[1] = position[2];
            position[2] = temp;
        }else{
            int temp = position[0];
            position[0] = position[2];
            position[2] = position[1];
            position[1] = position[3];
            position[3] = temp;

        }
        if(num[R][C]==0){
            num[R][C] = position[1];
        }else{
            position[1] = num[R][C];
            num[R][C] = 0;
        }

    }
    public static boolean rangeCheck(int r, int c, int dir){
        if(dir==1){
            if(c+1<M){
                C+=1;
                return true;
            }
        } else if (dir==2) {
            if(c-1>=0){
                C-=1;
                return true;
            }
        }else if(dir==3){
            if(r-1>=0){
                R-=1;
                return true;
            }
        }else{
            if(r+1 < N){
                R+=1;
                return true;
            }
        }
        return false;
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        position = new int[6];
        num = new int[N][M];
        orders = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

    }
}