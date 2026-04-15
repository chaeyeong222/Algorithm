import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;
        //먼저나오는 순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        
        int prev = routes[0][1]; //-15
        answer++;
        for(int i=1; i<n; i++){
            int s = routes[i][0];
            int e = routes[i][1];
            if(s<=prev){
                prev = Math.min(e, prev);
                continue;
            }else{
                answer++;
                prev = e;
            }
        }
        
        
        return answer;
    }
}