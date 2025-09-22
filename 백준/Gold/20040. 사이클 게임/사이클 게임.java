import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        boolean flag = false;
        int answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(flag) continue;
            if((union(a,b))){
                answer = i+1;
                flag = true;
            }
        }
        System.out.println(answer);
    }
    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) {
            parent[b] = a;
            return false;
        }else{
            return true;
        }
    }
    public static int find(int a){
        if(parent[a]!=a){
            return parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}
