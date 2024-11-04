import java.io.*;
import java.util.*;
//##
class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp==1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] root = new int[m];
        for (int i = 0; i < m; i++) {
            root[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = true;
        for (int i = 0; i < m-1; i++) {
            if(!isSameGroup(root[i],root[i+1])){
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");


    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }else {
            return parent[x] = find(parent[x]);
        }
    }
    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px!=py){
            parent[py] = px;
        }
    }
    static boolean isSameGroup(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py) return true;
        else return false;
    }
}