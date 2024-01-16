import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        //입력받은 값 넣기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        //오름차순정리
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        
        //방문순서 체크
        int[] visited = new int[N+1];
        int turn = 1;
        visited[R] = turn++;
        Queue<Integer> que = new LinkedList<>();
        que.offer(R);
        while(!que.isEmpty()){
            int now = que.poll();
            for (int nn : list[now]){
                if(visited[nn]==0){//방문안했다면
                    visited[nn]=turn++;
                    que.offer(nn);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        } 
    }
}