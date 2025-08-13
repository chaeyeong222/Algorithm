import java.util.*;
import java.io.*;
class Solution {
    static int[] arr; //멘토분배
    static int answer;
    public int solution(int k, int n, int[][] reqs) {
        answer = Integer.MAX_VALUE;
        arr = new int[k]; 
        find(0,k,n, reqs);
        //시간계산 
        return answer;
    }
    public void calTime(int k, int[][] reqs){
        int sum = 0; 
        PriorityQueue<Integer>[] pq = new PriorityQueue[k];
        for(int i=0; i<k; i++){
            pq[i] = new PriorityQueue<>();
        }
        
        for(int[] req : reqs){
            int start = req[0];
            int waste = req[1];
            int idx = req[2]-1;
            
            //끝난애들제거
            while(!pq[idx].isEmpty() && pq[idx].peek()<=start){
                pq[idx].poll();
            }
            
            if(pq[idx].size()<arr[idx]){
                pq[idx].offer(start+waste);
            }else{
                //가장먼저 끝나는 멘토 선택
                int finishTime = pq[idx].poll();
                sum += finishTime-start; //대기시간만합산
                
                pq[idx].offer(finishTime+waste);
            }
            
        } 
        answer = Math.min(answer, sum);
        
        
    }
    public void find(int depth, int k, int n, int[][] reqs){
        if(depth==k){
            if(n==0){ 
                calTime(k, reqs);
            }
            return;
        }
        
        for (int give = 1; give <= n - (k - depth - 1); give++) {
             arr[depth] += give; // 한 그룹에 여러 개 가능
             find(depth + 1, k, n - give, reqs); // give만큼 빼고 다음 depth
             arr[depth] -= give;
        }
    }
}

/**
n을 k개로 나눠 > 조합 무조건 1개이상은잇어야함
각 조합별로 시간계산
먼저온애 먼저 상담
*/