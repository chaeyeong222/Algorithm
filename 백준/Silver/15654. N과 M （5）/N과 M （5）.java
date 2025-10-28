

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] num;
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
        Arrays.sort(num);
        dfs(0);
        System.out.println(sb);

    }
    public static void dfs(int depth){
        if(depth==M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(' ');
            }sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = num[i];
                dfs(depth+1);
                visited[i] = false;
            }

        }

    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }


    }
}
