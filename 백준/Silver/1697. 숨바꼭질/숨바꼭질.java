import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,k;
    static boolean[] visited;
    static int move;
    static int[] jump = {-1, 1, 2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        move = 0;
        bfs(n,0);
        System.out.println(move);

    }
    public static void bfs(int nowPosition, int depth){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{nowPosition, depth});
        visited[nowPosition] = true;
        while (!que.isEmpty()){
            int[] now = que.poll();
            move = now[1];
            if(now[0]==k) break;
            for (int i = 0; i < 3; i++) {
                int np;

                if(i==2){
                    np = (now[0]*2);
                }else{
                    np = now[0]+jump[i];
                }
                if(np>=0 && np<=100000 && !visited[np]){
                    visited[np] = true;
                    que.offer(new int[]{np , now[1]+1});
                }
            }
        }
    }
}
