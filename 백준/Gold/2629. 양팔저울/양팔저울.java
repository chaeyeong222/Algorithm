import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] weight, ball;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        Set<Integer> possible = new HashSet<>();
        possible.add(0);

        for(int w : weight){
            Set<Integer> next = new HashSet<>(possible);
            for(int p : possible){
                next.add(p+w);
                next.add(Math.abs(p-w));
            }
            possible = next;
        }

        StringBuilder sb = new StringBuilder();
        for(int b : ball){
            if(possible.contains(b)) sb.append('Y').append(' ');
            else sb.append('N').append(' ');
        }
        System.out.println(sb);

    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        ball = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ball[i] = Integer.parseInt(st.nextToken());
        }
        
    }
}