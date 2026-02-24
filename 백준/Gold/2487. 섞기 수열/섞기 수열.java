import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static long answer;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        answer = 1;
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                long cycle = getCycle(i);
                answer = lcm(answer, cycle);
            }
        }
        System.out.println(answer);
    }
    public static long gcd(long a, long b){
        while(b!=0){
            long tmp = a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
    public static long lcm(long a, long b){
        return a/gcd(a,b)*b;
    }
    public static long getCycle(int idx){
        int cur = idx;
        long cnt = 0;
        while(!visited[cur]){
            visited[cur] = true;
            cur = num[cur]-1;
            cnt++;
        }
        return cnt;
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}
/**
 1 2 3 4 5 6
 3 2 5 6 1 4 >

 1 3 5
 2 2 > 1
 464 > 2
 * */