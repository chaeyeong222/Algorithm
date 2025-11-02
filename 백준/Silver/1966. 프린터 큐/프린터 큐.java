import java.io.*; 
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> que = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                que.offer(new int[]{i, temp});
                pq.offer(temp);
            }
            int cnt = 0;
            while(!que.isEmpty()){
                int[] now = que.poll();
                int nowIdx = now[0];
                int nowNum = now[1];

                int max = pq.peek();
                if(nowNum== max){
                    pq.poll();
                    cnt++;
                    if(nowIdx==m){
                        sb.append(cnt).append('\n');
                        break;
                    }
                }else{
                    que.offer(new int[]{nowIdx, nowNum});
                }
            }
        }
        System.out.println(sb);


    }
}