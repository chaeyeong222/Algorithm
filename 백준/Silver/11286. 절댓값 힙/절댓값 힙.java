import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>(){
            @Override
            public int compare(Long o1, Long o2){
                int absCompare = Long.compare(Math.abs(o1), Math.abs(o2));
                if(absCompare==0){
                    return Long.compare(o1, o2);
                }
                return absCompare;
            }
        });
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());

            if(x==0){
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(pq.poll()).append('\n');
                }
            }else{
                pq.add(x);
            }
        }
        System.out.println(sb);

    }
}