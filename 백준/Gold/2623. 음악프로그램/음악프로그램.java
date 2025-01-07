import java.io.*;
import java.util.*;
class Main {
    static int N,K;
    static List<Integer>[] list;
    static int[] indegree;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        if(answer[N-1]==0){
            System.out.println(0);
        }else{
            for (int i = 0; i < N; i++) {
                sb.append(answer[i]).append('\n');
            }
            System.out.println(sb);
        }

    }
    public static void pro(){

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            if(indegree[i]==0) que.add(i);
        }
        int idx = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            answer[idx++] = now;
            for(int next : list[now]){
                indegree[next]--;
                if(indegree[next]==0){
                    que.offer(next);
                }
            }
        }

    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        answer = new int[N];
        indegree = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int peo = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 0; j < peo-1; j++) {
                int next = Integer.parseInt(st.nextToken());
                
                indegree[next]++;
                list[prev].add(next);
                prev = next;
            }
        }
    }
}