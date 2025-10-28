import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        arr = new int[M];
        visited = new boolean[N];
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int depth){
        if(depth==M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[depth]= i;
            dfs(depth+1);
        }

    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}