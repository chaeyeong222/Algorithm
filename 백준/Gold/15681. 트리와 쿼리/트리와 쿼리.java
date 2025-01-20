import java.io.*;
import java.util.*;
class Main {
    static int N, root, Q;
    static List<Integer>[] list;
    static int ans; 
    static int[] Dy;
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print() throws Exception{
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(Dy[num]).append('\n');
        }
        System.out.println(sb);
    }
    public static void pro(){
        dfs(root, -1);
    }
    public static void dfs(int key, int prev){
        Dy[key] = 1;
        for(int next : list[key]){
            if(next == prev) continue;
            dfs(next, key);
            Dy[key] += Dy[next];
        }
    }
    static void set() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        ans = 0;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int numA = Integer.parseInt(st.nextToken());
            int numB = Integer.parseInt(st.nextToken());
            list[numA].add(numB);
            list[numB].add(numA);
        } 
        Dy = new int[N+1];

    }
}