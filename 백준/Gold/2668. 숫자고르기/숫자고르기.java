
import java.io.*;
import java.util.*;
//## 2668 숫자고르기
class Main {
    static List<Integer> list;
    static int N;
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);
    }
    public static void pro(){
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
    }
    public static void dfs(int now, int target){
        if(!visited[num[now]]){
            visited[num[now]] = true;
            dfs(num[now], target );
            visited[num[now]] = false;
        }
        if(num[now]==target) list.add(target);
    }
    public static void set() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
    }
}