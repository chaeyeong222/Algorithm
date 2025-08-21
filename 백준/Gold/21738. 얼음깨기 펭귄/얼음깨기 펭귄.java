
import java.io.*;
import java.util.*;

public class Main {
    static int N,M, start;
    static List<Integer>[] list;
    static int[] cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
         set();
         pro();
    }
    public static void pro(){
        find();
        Arrays.sort(cnt); 
        System.out.println(N-1-cnt[1]-cnt[2]);//펭귄있는곳도 제외
    }
    public static void find(){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{start, 0});
        visited[start] = true;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int now = temp[0];
            int step = temp[1];
            if(now<=M && cnt[now]==0){
                cnt[now] = step;
            }
            for(int next : list[now]){
                if(!visited[next]){
                    que.offer(new int[]{next, step+1});
                    visited[next] = true;
                }
            }
        }
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        cnt = new int[M+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
} 