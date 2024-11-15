import java.io.*;
import java.util.*;
//##
class Main {
    static boolean[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int order = Integer.parseInt(br.readLine());
            if(order==0 && que.isEmpty()){
                sb.append(0).append('\n');
            }else if(order==0){
                sb.append(que.poll()).append('\n');
            }else{
                que.offer(order);
            }
        }
        System.out.println(sb);
    }


}