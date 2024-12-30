import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

//## 촌수계산
class Main {
    static int N, num1, num2, K;
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    public static void pro(){
        Queue<int[]> que = new LinkedList<>(); //숫자, 촌수
        que.offer(new int[]{num1,0});
        visited[num1] = true;
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(now[0]==num2){
                answer = now[1];
                break;
            }
            for(int temp : list[now[0]]){
                if(!visited[temp]) {
                    visited[temp] = true;
                    que.offer(new int[]{temp, now[1]+1});
                }
            }
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        visited = new boolean[N+1];
        answer = -1;
    }
}