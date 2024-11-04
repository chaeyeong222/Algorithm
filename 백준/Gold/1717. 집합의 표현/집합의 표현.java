import java.io.*;
import java.util.*;
//##1717
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int orders = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());
            if(orders==0){
                union(xx,yy);
            }else{
                if(sameGroup(xx,yy)) {sb.append("YES").append('\n');}
                else {sb.append("NO").append('\n');}
            }
        }
        System.out.println(sb);


    }
    public static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px!=py){
            parent[py] = px;
        }
    }
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }
    public static boolean sameGroup(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py){
            return true;
        }
        return false;
    }
}
