import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<Integer>[] list;
    static List<Integer> team1;
    static List<Integer> team2;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        Collections.sort(team1);
        Collections.sort(team2);
        StringBuilder sb = new StringBuilder();
        sb.append(team1.size()).append('\n');
        for(int n : team1){
            sb.append(n).append(' ');
        }sb.append('\n');

        sb.append(team2.size()).append('\n');
        for(int n : team2){
            sb.append(n).append(' ');
        }

        System.out.println(sb);
    }
    public static void pro() {
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) bfs(i);
        }
    }
    
    public static void bfs(int start){
        team1.add(start);
        visited[start] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{start,1});//idx, 팀번호
        while (!que.isEmpty()){
            int[] temp = que.poll();
            int now = temp[0];
            int teamNum = temp[1];
            for(int next: list[now]){
                if(!visited[next]){
                    if(teamNum==1) {
                        team2.add(next);
                        que.offer(new int[]{next,2});
                    }else{
                        team1.add(next);
                        que.offer(new int[]{next,1});
                    }
                    visited[next] = true;
                }
            }
        }
        
    }
    
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[i].add(num);
                list[num].add(i);
            }
        }
        team1 = new ArrayList<>();
        team2 = new ArrayList<>();
        visited = new boolean[N+1];
    }
}