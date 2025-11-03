import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[] num;
    static boolean[] robot;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int step = 0;
        while(true){
            step++;
            rotate(); //회전
            moveRobots(); //로봇이동
            if(num[0]>0){
                robot[0] = true;
                num[0]--;
            }
            if(cntZero()>=K) break;
        }
        System.out.println(step);
    }
    public static int cntZero(){
        int count = 0;
        for (int i = 0; i < 2*N; i++) {
            if(num[i]==0){
                count++;
            }
        }
        return count;
    }
    public static void moveRobots(){
        for (int i = N-1; i > 0; i--) {
            if(robot[i-1] && !robot[i] && num[i]>0){
                robot[i] = true;
                num[i]--;
                robot[i-1] = false;
            }
        }
        robot[N-1] = false;

    }
    public static void rotate(){
        int last = num[2 * N -1];
        for (int i = 2*N-1; i >0; i--) {
            num[i] = num[i-1];
        }num[0] = last;

        for (int i = N-1; i > 0; i--) {
            robot[i] = robot[i-1];
        }
        robot[0] = false;
        robot[N-1] = false;
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[2*N];
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i< 2*N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}