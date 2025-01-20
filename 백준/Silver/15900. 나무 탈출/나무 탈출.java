import java.io.*;
import java.util.*;
class Main {
    static int N;
    static List<Integer>[] list;
    static int ans;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        if(ans % 2 == 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    public static void pro(){
        boolean[] visited = new boolean[N+1];
        dfs(1,0, visited);
    }
    public static void dfs(int key, int cnt  , boolean[] visited){
        visited[key] = true;
        for(int next : list[key]){
            if(!visited[next]){ dfs(next, cnt+1, visited);}
        }

        if(key!=1 && list[key].size()==1){
            ans += cnt;
        }
    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
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

    }
}
