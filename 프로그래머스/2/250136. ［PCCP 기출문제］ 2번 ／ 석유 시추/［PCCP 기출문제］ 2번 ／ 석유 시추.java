import java.util.*;

class Solution {
    Map<Integer,Integer> map;
    int[][] land;
    int n,m;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int solution(int[][] land) {
        int answer = 0;
        this.land = land;
        n = land.length;
        m = land[0].length;
        map = new HashMap<>();
        int idx = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1){
                    bfs(i,j,idx++);
                }
            }
        }
        
        //시추관
        for(int i=0; i<m ; i++){
            answer = Math.max(answer, digg(i));
        }
        return answer;
    }
    public int digg(int num){
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i=0; i<n; i++){
            int oil = land[i][num];
            if(oil!=0 && !set.contains(oil)){
                sum += map.get(oil);
                set.add(oil);
            }
        }
        return sum;
    }
    public void bfs(int r, int c, int idx){
        Queue<int[]> que = new LinkedList<>();
        int cnt = 1;
        que.offer(new int[]{r,c});
        land[r][c] = idx;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int rr = temp[0];
            int cc = temp[1];
            for(int i=0; i<4; i++){
                int nr = rr+dr[i];
                int nc = cc+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && land[nr][nc]==1){
                    land[nr][nc] = idx;
                    cnt++;
                    que.offer(new int[]{nr,nc});
                }
            } 
        }
        map.put(idx, cnt);
    }
}