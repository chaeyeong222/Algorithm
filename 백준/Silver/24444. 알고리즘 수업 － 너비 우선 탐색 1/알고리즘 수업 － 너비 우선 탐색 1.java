import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        for (int i = 0; i < N+1; i++) {
            Collections.sort(list[i]);
        }

        int[] visited = new int[N+1];
        Arrays.fill(visited,0);

        int turn = 1;

        Queue<Integer> que = new LinkedList<>();
        que.offer(R);
        visited[R]=turn++;
        while(!que.isEmpty()){
            int check = que.poll();
            for(int num : list[check]){
                if(visited[num]==0){
                    visited[num]=turn++;
                    que.offer(num);
                }
            }
        }
        for(int i=1; i<visited.length; i++){
            System.out.println(visited[i]);
        }


    }
}