import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] time;
    static int[] dp;
    static long answer;
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        time = new int[n][2];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(time[0][1]);
        for (int i = 1; i < n; i++) {
            if(time[i][0]>=pq.peek()){
                pq.poll();
            }
            pq.add(time[i][1]);
        }
        System.out.println(pq.size());
    }
}
