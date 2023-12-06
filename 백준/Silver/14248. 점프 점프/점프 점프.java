import java.util.*;
import java.io.*;

class Main {
    static boolean[] check;
    static int[] stone;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stone = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());
        bfs(start-1);

        int cnt = 0;
        for (int i = 0; i < check.length; i++) {
            if(check[i]) cnt++;
        }
        System.out.println(cnt);

    }
    public static void bfs(int now){
        if(now<0 || now>=n || check[now]){
            return;
        }
        check[now]=true;
        bfs(now+stone[now]);
        bfs(now-stone[now]); 
    }
}