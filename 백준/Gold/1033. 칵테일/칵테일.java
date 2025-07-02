import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Ratio>[] list;
    static long[] ratio;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (long r : ratio) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }

    public static void pro() {
        ratio[0] = 1;
        dfs(0);

        // 모든 ratio의 최대공약수로 나누어 최소 질량 만들기
        long g = ratio[0];
        for (int i = 1; i < N; i++) {
            g = gcd(g, ratio[i]);
        }
        for (int i = 0; i < N; i++) {
            ratio[i] /= g;
        }
    }

    public static void dfs(int now){
        visited[now] = true;
        for(Ratio r : list[now]){
            if(!visited[r.to]){
                // ratio[to] = ratio[now] * q / p
                ratio[r.to] = ratio[now] * r.q;
                long g = gcd(ratio[r.to], r.p);
                ratio[r.to] /= g;
                long base = r.p / g;
                for (int i = 0; i < N; i++) {
                    if (visited[i]) ratio[i] *= base;
                }
                dfs(r.to);
            }
        }
    }

    public static long gcd(long a, long b){
        return b==0 ? a: gcd(b, a % b);
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N];
        for (int i = 0; i < N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            list[a].add(new Ratio(b, p, q));
            list[b].add(new Ratio(a, q, p)); // 비율 반대로
        }

        ratio = new long[N];
        visited = new boolean[N];
    }

    static class Ratio {
        int to, p, q;
        Ratio(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }
}
