import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] way = new int[N+2][2];
            StringTokenizer st;
            for (int i = 0; i < N+2; i++) {
                st = new StringTokenizer(br.readLine());
                way[i][0] = Integer.parseInt(st.nextToken());
                way[i][1] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] list = new ArrayList[N+3];
            for (int i = 0; i < N+2; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < N+1; i++) {
                for (int j = i; j < N+2; j++) {
                    if(Math.abs(way[i][0]-way[j][0]) + Math.abs(way[i][1]-way[j][1])<=1000){
                        list[i].add(j);
                        list[j].add(i);
                    }
                }
            }
            boolean flag = false;

            Queue<Integer> que = new LinkedList<>();
            boolean[] visited = new boolean[N+3];
            que.offer(0);
            visited[0] = true;
            while(!que.isEmpty()){
                int now = que.poll();
                if(now==N+1){
                    flag = true;
                    break;
                }
                for(int next : list[now]){
                    if(!visited[next]) {
                        que.offer(next);
                        visited[next] = true;
                    }
                }
            }
            if(flag) sb.append("happy").append('\n');
            else sb.append("sad").append('\n');
        }
        System.out.println(sb);
    }
}
