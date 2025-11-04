import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 0; i < list.size()-1; i++) {
            sb.append(list.get(i));
            sb.append(", ");
        }
        sb.append(list.get(N-1)).append('>');
        System.out.println(sb);

    }
    public static void pro(){
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }
        list = new ArrayList<>();
        while(true){
            int turn = 1;
            while(que.size()>1){
                int a = que.poll();
                if(turn==K){
                    list.add(a);
                    break;
                }else{
                    que.offer(a);
                }
                turn++;
            }
            if(que.size()==1){
                break;
            }
        }
        list.add(que.poll());
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


    }
} 