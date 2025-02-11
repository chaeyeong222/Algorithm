import java.io.*;
import java.util.*;
class Main {
    static int N, target1, target2;
    static int[] parent, depth;
    static StringBuilder sb;
    static int root;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            depth = new int[N+1];
//            Arrays.fill(parent, -1);
            for (int i = 0; i < N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                parent[num2]=num1; //num2의 부모 num1
            }
            st = new StringTokenizer(br.readLine());
            target1 = Integer.parseInt(st.nextToken());
            target2 = Integer.parseInt(st.nextToken());

            root = findRoot();

            checkDepth(root, 0);

            sb.append(findLCA(target1, target2)).append('\n');

        }
        System.out.println(sb);
    }
    static int findRoot() {
        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) return i;
        }
        return -1;
    }
    public static void checkDepth(int node, int dep){
        depth[node] = dep;
        for (int i = 1; i <= N; i++) {
            if(parent[i]==node){
                checkDepth(i, dep+1);
            }
        }
    }
    public static int findLCA(int a, int b){
        while(depth[a] > depth[b]) a = parent[a];
        while(depth[a] < depth[b]) b = parent[b];
        //깊이 맞추는 과정

        while(a!=b){
            a = parent[a];
            b = parent[b];
        }

        return a;

    }
}