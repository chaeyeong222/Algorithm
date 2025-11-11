import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Queue<int[]>> lines = new ArrayList<>();
    static PriorityQueue<int[]> pq; //나와야하는 순서
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        Stack<int[]> stack = new Stack<>();//알파벳, 숫자
        for(Queue<int[]> q : lines){
            while(!q.isEmpty()){
                int[] now = q.poll(); //현재 입장을 원하는 순서
                while(!stack.isEmpty() && pq.peek()!=null && stack.peek()[0]==pq.peek()[0] && stack.peek()[1]==pq.peek()[1]){ //대기열에 있는 애들이 들어갈 수 있다면?
                    stack.pop();
                    pq.poll();
                }
                if(now[0]==pq.peek()[0] && now[1]==pq.peek()[1]){ //실제 들어갈 수 있는 순서라면?
                    pq.poll();
                }else{
                    stack.push(now); //아니면 대기열로 들어감
                }
            }
        }
        while(!stack.isEmpty() && pq.peek()[0]==stack.peek()[0] && pq.peek()[1] ==stack.peek()[1]){
            stack.pop();
            pq.poll();
        }
        System.out.println(pq.isEmpty()? "GOOD" : "BAD");
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            for (int j = 0; j < 5; j++) {
                String tt = st.nextToken();
                String[] temp = tt.split("-");
                int alpa = temp[0].charAt(0)-'A';
                int num = Integer.parseInt(temp[1]);
                pq.offer(new int[]{alpa, num});
                q.offer(new int[]{alpa, num});
            }
            lines.add(q);
        }
    }
}