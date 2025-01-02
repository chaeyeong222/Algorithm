import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] dist;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        bfs();
        System.out.println(answer-1);
    }
    public static void bfs(){
        Arrays.fill(dist, -1);

        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        dist[1] = 0;
        while(!que.isEmpty()){
            int temp = que.poll();
            if(dist[temp]<=2) answer++;
            for (int nn : list[temp]){
                if(dist[nn]!=-1) continue;
                dist[nn] = dist[temp] + 1;
                que.offer(nn);
            }
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
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
    }
}