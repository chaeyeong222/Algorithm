import java.util.*;
class Solution  {
    int[] parent;
    int[] size;
    public int solution(int n, int[][] costs) { 
        parent = new int[n+1];
        size = new int[n+1];
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for(int i=0; i<=n ; i++){
            parent[i] = i;
        }
        int total = 0;
        for(int[] c : costs){
            int x = c[0];
            int y = c[1];
            int z = c[2];
            if(find(x)!=find(y)){
                total += z;
                union(x,y);
            }
        } 
    
        return total; 
    } 
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){
            if(size[pa]>=size[pb]){
                parent[pb] = pa;
                size[pa] += size[pb];
            }else{
                parent[pa] = pb;
                size[pb] += size[pa];
            }
        }
    }
    public int find(int x){
        if(parent[x] != x){
            return find(parent[x]);
        }
        return x;
    }
}