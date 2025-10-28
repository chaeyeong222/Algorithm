

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] num;
    static int[] arr;
    static Set<List<Integer>> set ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        arr = new int[M];
        set = new HashSet<>();
        Arrays.sort(num);
        dfs( -1,0,0);
        System.out.println(sb);

    }
    public static void dfs(int prevIdx, int prev, int depth){
        if(depth==M){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                list.add(arr[i]);
            }
            if(!set.contains(list)){
                set.add(list);
                for (int i = 0; i < M; i++) {
                    sb.append(list.get(i)).append(' ');
                }sb.append('\n');
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(prevIdx < i && prev <= num[i]){
                arr[depth] = num[i];
                dfs(i, num[i], depth+1);
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
