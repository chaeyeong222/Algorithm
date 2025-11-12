import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static PriorityQueue<Person> pq;
    static Queue<Person>[] que;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int cnt = 0;
        while (true){
            Person p = pq.poll();//
            if(p.isDeca){ //이번이용자가 데카면 그만
                break;
            }
            int idx = p.lineNum; //해당줄 다음사람 넣어줌
            if(!que[idx].isEmpty()){
                pq.offer(que[idx].poll());
            }
            cnt++;
        }
        System.out.println(cnt);
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>(new Comparator<Person>(){
           @Override
           public int compare(Person o1, Person o2){
               if(o1.workingdays== o2.workingdays){
                   if(o1.hurry==o2.hurry) return o1.lineNum-o2.lineNum;
                   return o2.hurry-o1.hurry;
               }
               return o2.workingdays-o1.workingdays;
           }
        });

        que = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            que[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int line = (i%M);
            boolean flag = false;
            if(i==K) flag = true;
            que[line].offer(new Person(line, w,h,flag));
        }

        //선두넣어줌
        for (int i = 0; i < que.length; i++) {
            if(!que[i].isEmpty()) pq.offer(que[i].poll());
        }

    }
}
class Person{
    int lineNum;
    int workingdays;
    int hurry;
    boolean isDeca;
    Person(int lineNum, int workingdays, int hurry, boolean isDeca){
        this.lineNum = lineNum;
        this.workingdays = workingdays;
        this.hurry = hurry;
        this.isDeca = isDeca;
    }
} 