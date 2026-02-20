import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb;
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        //hanoi(M, from, to, serve);
        hanoi(M, 1,3,2);
        System.out.println(K);
        System.out.println(sb);

    }
    public static void hanoi(int cnt, int from, int to, int serve){
        if(cnt==1){
            K++;
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        K++;
        hanoi(cnt-1, from, serve, to);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(cnt-1, serve, to, from);
    }
}