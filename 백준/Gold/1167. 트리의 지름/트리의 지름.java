import java.io.*;
import java.util.*;

public class Main {
    static int N, maxDist, farNodeIdx;
    static List<Node>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        visited = new boolean[N+1];
        maxDist = 0;
        bfs(1, 0);

        visited = new boolean[N+1];
        maxDist = 0;
        bfs(farNodeIdx, 0);

        System.out.println(maxDist);
    }
    public static void bfs(int idx, int dist){
        if(dist > maxDist){
            maxDist = dist;
            farNodeIdx = idx;
        }
        visited[idx] = true;
        for(Node next : list[idx]){
            if(!visited[next.idx]){
                bfs(next.idx, dist + next.dist);
            }
        }
    }

    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nowIdx = Integer.parseInt(st.nextToken());
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next==-1) break;
                else{
                    int distance = Integer.parseInt(st.nextToken());
                    list[nowIdx].add(new Node(next, distance));
                    list[next].add(new Node(nowIdx, distance));
                }
            }
        }
    }
}
class Node{
    int idx;
    int dist;
    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
}

