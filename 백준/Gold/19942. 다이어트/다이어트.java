import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] pivot = new int[4];
    static int[][] num;
    static long minAnswer = Long.MAX_VALUE;
    static List<Integer> picked = new ArrayList<>();
    static List<Integer> best = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        dfs(0,0,0,0,0,0);
        if(minAnswer==Long.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(minAnswer).append('\n');
        for (int i = 0; i < best.size(); i++) {
            if(i>0) sb.append(' ');
            sb.append(best.get(i));
        }
        System.out.println(sb);

    }
    public static void dfs(int idx, int d, int t, int j, int b, long cost){
        if(cost> minAnswer) return;

        if(idx==N){
            if(d>=pivot[0] && t>=pivot[1] && j>=pivot[2] && b >= pivot[3]){
                if(cost < minAnswer){
                    minAnswer = cost;
                    best = new ArrayList<>(picked);
                }else if(cost==minAnswer){
                    if(isFaster(picked, best)){
                        best = new ArrayList<>(picked);
                    }
                }
            }
            return;
        }
        picked.add(idx+1);
        dfs(idx+1, d+num[idx][0], t+num[idx][1], j+num[idx][2], b+num[idx][3], cost+num[idx][4]);
        picked.remove(picked.size()-1);

        dfs(idx+1, d,t,j,b,cost);
    }
    static boolean isFaster(List<Integer> a, List<Integer> b) {
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            int x = a.get(i), y = b.get(i);
            if (x != y) return x < y;
        }
        return a.size() < b.size();
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N][5];
        pivot = new int[4];
        for (int i = 0; i < 4; i++) {
            pivot[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 5; k++) {
                num[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}