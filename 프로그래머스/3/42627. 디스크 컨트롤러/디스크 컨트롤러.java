import java.util.*;

class Solution {
    int n;
    int[][] jobs;  
    public int solution(int[][] jobs) {
        int answer = 0;
        n = jobs.length;
        this.jobs = jobs; 
        Arrays.sort(jobs, (a,b)->(a[0]-b[0])); //시간순 정렬
        
        //우선순위큐
        PriorityQueue<Work> pq = new PriorityQueue<>(new Comparator<Work>(){
           @Override
            public int compare(Work w1, Work w2){
                if(w1.wasteTime == w2.wasteTime){
                    if(w1.requestTime==w2.requestTime){
                        return w1.idx-w2.idx;
                    }
                    return w1.requestTime-w2.requestTime;
                }
                return w1.wasteTime - w2.wasteTime;
            }
        });
         
        int sum = 0;
        int nowTime = 0;
        
        
        int i = 0;
        while(i<n || !pq.isEmpty()){
            while (i < n && jobs[i][0] <= nowTime) { //들어온 요청 체크
                pq.offer(new Work(jobs[i][1], jobs[i][0], i));
                i++;
            }

            if (pq.isEmpty()) { //pq비면 시간점프
                nowTime = jobs[i][0];
                continue;
            }
 
            Work now = pq.poll();
            nowTime += now.wasteTime;
            
            
            sum += (nowTime - now.requestTime);
        }   
         return sum/n;
    }
}
class Work{
    int wasteTime;
    int requestTime;
    int idx;
    public Work(int wasteTime,int requestTime,int idx){
        this.wasteTime = wasteTime;
        this.requestTime = requestTime;
        this.idx = idx;
    }
} 