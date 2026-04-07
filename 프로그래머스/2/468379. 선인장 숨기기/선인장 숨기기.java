import java.util.Arrays;

class Solution {
    int m, n, h, w;
    int[] pref;
    int[][] drops;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        this.m = m;
        this.n = n;
        this.h = h;
        this.w = w;
        this.drops = drops;
            
        this.pref = new int[(m+1)*(n+1)];
        
        int low = 0;
        int high = drops.length;
        int[] ans = new int[]{0,0};
        
        while(low<=high){
            int mid = (low+high)/2;
            int[] coord = check(mid);
            
            if(coord != null){
                ans = coord;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public int[] check(int k){
        Arrays.fill(pref, 0);
        
        for(int i=0; i<k; i++){
            int r = drops[i][0]+1;
            int c = drops[i][1]+1;
            pref[r*(n+1)+c] = 1;
        }
        
        for(int i=1; i<=m ; i++){
            int rowOffset = i*(n+1);
            int prevRowOffset = (i-1)*(n+1);
            for(int j=1; j<=n; j++){
                pref[rowOffset +j] += pref[prevRowOffset+j] + pref[rowOffset +j-1]
                    - pref[prevRowOffset +j-1];
            }
        }
        
        
        for(int i=0; i<=m-h; i++){
            int r1 = i;
            int r2 = i+h;
            for(int j=0; j<=n-w; j++){
                int c1 = j;
                int c2 = j+w;
                
                int sum = pref[r2 * (n + 1) + c2] 
                        - pref[r1 * (n + 1) + c2] 
                        - pref[r2 * (n + 1) + c1] 
                        + pref[r1 * (n + 1) + c1];
                
                if (sum == 0) {
                    return new int[]{i, j}; // 구역을 찾으면 즉시 해당 좌표 반환
                }
            }
        }
        return null;
    }
}