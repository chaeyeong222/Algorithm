import java.io.*;
import java.util.*;
//#2075 n번째 큰 수
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1; //내림차순정렬
            }
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }//
        for (int i = 0; i < n-1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}