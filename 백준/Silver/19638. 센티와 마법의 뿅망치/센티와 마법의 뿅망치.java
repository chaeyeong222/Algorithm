import java.io.*;
import java.util.*;
public class Main {
    static int N, centi, T;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){

        int cnt = 0;
        while(T-->0){
            if(pq.peek()< centi){ break; }

            int num = pq.poll();
            if(num==1){
                pq.offer(1);
                break;
            }
            pq.offer(num/2);
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        if(pq.peek()<centi){
            sb.append("YES").append('\n').append(cnt);
        }else{
            sb.append("NO").append('\n').append(pq.poll());
        }
        System.out.println(sb);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        centi = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
    }
}