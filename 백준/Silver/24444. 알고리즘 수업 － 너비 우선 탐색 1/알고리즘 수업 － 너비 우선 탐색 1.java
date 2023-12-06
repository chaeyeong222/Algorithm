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
        int r = Integer.parseInt(st.nextToken());
        int idx = 1;
        PriorityQueue<Integer>[] list = new PriorityQueue[n+1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new PriorityQueue<>();
        }
        int[] visited = new int[n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
//        for (int i = 1; i <= n; i++) {
//            Collections.sort(list[i]);
//        }
        Queue<Integer> que = new LinkedList<>();
        que.offer(r);
        visited[r] = idx++;
        while(!que.isEmpty()){
            int check = que.poll();
            while(!list[check].isEmpty()){
                int aaa = list[check].poll();
                if(visited[aaa]==0){
                    que.offer(aaa);
                    visited[aaa] = idx++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
        }


    }

}
