import java.io.*;
import java.util.*;

public class Main {
    static int N, M; 
    public static void main(String[] args) throws IOException {
        set();
        pro(); 
    }
    public static void pro(){
        Queue<long[]> que = new LinkedList<>();
        que.offer(new long[]{N,0});
        while(!que.isEmpty()){
            long[] temp = que.poll();
            if(temp[0]==M) {
                System.out.println(temp[1]+1);
                return;
            }
            if(temp[0]*2<=M){
                que.offer(new long[]{temp[0]*2, temp[1]+1});
            }
            if(temp[0]*10+1<=M){
                que.offer(new long[]{temp[0]*10+1, temp[1]+1});
            }
        }
        System.out.println(-1);
    }

    static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
    }
}
