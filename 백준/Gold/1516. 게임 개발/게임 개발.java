import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] indegree;
    static int[] time;
    static List<Integer>[] list;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(indegree[i]==0)  {
                answer[i] = time[i];
                que.offer(i);
            }
        }
        while(!que.isEmpty()){
            int now = que.poll();
            for(int next: list[now]){ //next = 다음에 할 애
                indegree[next]--;
                answer[next] = Math.max(answer[next], answer[now]+time[next]);
                if(indegree[next]==0) que.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        indegree = new int[N+1];
        time = new int[N+1];
        answer = new int[N+1];
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i= 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int waste = Integer.parseInt(st.nextToken());
            time[i] = waste;
            while(true){
                int temp = Integer.parseInt(st.nextToken());
                if(temp==-1) break;
                else{
                    list[temp].add(i);
                    indegree[i]++;
                }
            }
        }
    }
}