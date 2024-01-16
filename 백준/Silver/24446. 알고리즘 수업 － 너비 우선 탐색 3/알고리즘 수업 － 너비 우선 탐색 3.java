import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //정점수
        int m = Integer.parseInt(st.nextToken()); //간선수
        int r = Integer.parseInt(st.nextToken()); //시작정점
        int[] visited = new int[n+1];//방문체크
        List<Integer>[] list = new ArrayList[n+1];
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
        Arrays.fill(visited, -1);
        int depth = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(r);
        visited[r] = depth;
        while (!q.isEmpty()){
            int check = q.poll();//하나 꺼내서
            for (int nnn : list[check]) {
                if(visited[nnn]==-1){
                    q.offer(nnn);
                    visited[nnn]=visited[check]+1;
                }
            }
            depth+=1;
        }
        for (int i = 1; i < n+1; i++) {
            System.out.println(visited[i]);
        }

    }
}