import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int maxCnt = 0;
    static int[] visited;
    static List<Integer> answer;
    static int visitId = 1;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        for (int i = 1; i <= N; i++) {
            startAt(i);
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int a : answer){
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }
    public static void startAt(int idx){
        visited[idx] = visitId;
        int cnt = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.offer(idx);
        while(!que.isEmpty()){
            int now = que.poll();
            cnt++;
            for(int next: list[now]){
                if(visited[next] != visitId){
                    que.offer(next);
                    visited[next] = visitId;
                }
            }
        }

        if(cnt==maxCnt) {
            answer.add(idx);
        }else if(cnt>maxCnt){
            maxCnt = cnt;
            answer = new ArrayList<>();
            answer.add(idx);
        }
        visitId++;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new int[N+1];
        answer = new ArrayList<>();
        for (int i= 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }
    }
}