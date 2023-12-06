import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //정점수
        int m = Integer.parseInt(st.nextToken()); //간선수
        int r = Integer.parseInt(st.nextToken()); //시작정점
        visited = new int[n+1];

        list = new ArrayList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(visited, -1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        for (int i = 0; i < list.length; i++) {
            Collections.sort(list[i]);
        }

        dfs(r,0);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }

    }
    public static void dfs(int num, int depth){
        if(visited[num]!=-1){
            return;
        }
        visited[num] = depth;
        for (int aa : list[num]) {
            dfs(aa, depth+1);
        }
    }
}