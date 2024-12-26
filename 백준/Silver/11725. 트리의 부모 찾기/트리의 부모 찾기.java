import com.sun.media.jfxmedia.events.VideoTrackSizeListener;

import java.io.*;
import java.util.*;
//## 11725
class Main {
    static int N;
    static List<Integer>[] list;
    static int[][] map;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        set();
        bfs(1);
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        while(!que.isEmpty()){
            int now = que.poll();
            for(int temp : list[now]){
                if(answer[temp]!=0) continue;//이미 방문
                answer[temp] = now;
                que.offer(temp);
            }
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        answer = new int[N+1];
        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }//for
    }
}