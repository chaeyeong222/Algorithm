import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
//## 베이컨의 6단계 법칙

class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] dist;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    static void print(){
        int minNum = Integer.MAX_VALUE;
        int minCnt = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if(answer[i] < minCnt ){
                minCnt = answer[i];
                minNum = i;
            }
        }
        System.out.println(minNum);
    }
    public static void bfs(int now){
        Arrays.fill(dist, 0);
        visited = new boolean[N+1];

        int sum = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(now);
        visited[now] = true;
        while(!que.isEmpty()){
            int temp = que.poll();
            for (int nn : list[temp]){
                if(visited[nn]) continue;
                dist[nn] = dist[temp] + 1;
                sum += dist[temp] - 1;
                visited[nn] = true;
                que.offer(nn);
            }
        }
        answer[now] = sum;
    }
    public static void pro(){
        for (int i = 1; i < N+1; i++) {
            bfs(i);
        }

    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        dist = new int[N+1];
        answer = new int[N+1];

    }
}