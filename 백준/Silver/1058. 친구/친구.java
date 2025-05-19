import java.io.*;
import java.util.*;

class Main {
    static int n;
    static char[][] map;
    static List<Integer>[] list;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(map[i][j]=='Y'){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            check(i);
        }
        System.out.println(ans);
    }
    public static void check(int pivot){
        boolean[] visited = new boolean[n];
        visited[pivot]= true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{pivot,0});
        int cnt = 0;
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(now[1]==2) continue;
            for(int next : list[now[0]]){
                if(!visited[next]){
                    visited[next] = true;
                    que.offer(new int[]{next, now[1]+1});
                    cnt ++;
                }
            }
        }
        ans = Math.max(cnt, ans);
    }
}
