import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] visited;
    static int turn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //정점수
        int m = Integer.parseInt(st.nextToken()); //간선수
        int r = Integer.parseInt(st.nextToken()); //시작정점
        visited = new int[n+1];//
        list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int line1 = Integer.parseInt(st.nextToken());
            int line2 = Integer.parseInt(st.nextToken());
            list[line1].add(line2);
            list[line2].add(line1);
        }

        for (int i = 1; i < list.length; i++) {
            Collections.sort(list[i]);
        }
        turn = 1;
        visited[r]=turn++;
        dfs(r);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }

    }
    public static void dfs(int num){
//         if(visited[num]!=0){
//             return;
//         }
        for (int aa: list[num]) {
            if(visited[aa]==0){
                visited[aa]=turn++;
                dfs(aa);
            }
        }
    }//
}