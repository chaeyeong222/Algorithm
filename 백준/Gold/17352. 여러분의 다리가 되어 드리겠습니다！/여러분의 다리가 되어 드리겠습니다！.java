import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[] parent;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (find(i) != find(j)) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        ans = new int[2];
        for (int i = 0; i < N-2 ; i++) {
            st =  new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            union(num1, num2);
        }
    }
    public static void union(int a, int b){
        int pA = find(a);
        int pB = find(b);
        if(pA!=pB){
            parent[pB] = pA;
        }
    }
    public static int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}