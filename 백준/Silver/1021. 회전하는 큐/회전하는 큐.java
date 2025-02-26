import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = deque.indexOf(target);

            
            int half;
            
            if(deque.size()%2==0){//짝수일 경우
                half = deque.size()/2-1;
            }else{
                half = deque.size()/2;
            }

            
            if(targetIdx <= half){
                for (int j = 0; j < targetIdx; j++) {
                    int temp = deque.pollFirst();
                    deque.addLast(temp);
                    cnt++;
                }
            }else{
                for (int j = 0; j < deque.size()-targetIdx; j++) {
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    cnt++;
                }
            }
             
            deque.pollFirst();

        }
        System.out.println(cnt);


    }

}