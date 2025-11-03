import java.io.*;
import java.util.*;

public class Main {
    static int N, len, bridgW;
    static int[] num;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int nowTime = 0;
        int nowW = 0;
        Queue<int[]> que = new LinkedList<>();
        int idx = 0;
        while(idx<N){

            nowTime++;
            while(!que.isEmpty() && que.peek()[1] <= nowTime){
                nowW -= que.poll()[0];
            }

            int truck = num[idx];
            if(idx<N && nowW + truck <= bridgW ){
                que.offer(new int[]{truck, len+nowTime});
                nowW += truck;
                idx++;
            }
        }

        while(!que.isEmpty()){
            nowTime=que.peek()[1];
            que.poll();
        }
        System.out.println(nowTime);

    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        bridgW = Integer.parseInt(st.nextToken());
        num = new int[N];
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}