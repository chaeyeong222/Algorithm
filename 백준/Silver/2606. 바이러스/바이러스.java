import java.io.*;
import java.util.*;
//## 2606
class Main {
    static int N, K;
    static Set<Integer> set;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        set();
        bfs();
        System.out.println(set.size()-1);
    }

    static void bfs(){
        set = new HashSet<>();
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        set.add(1);
        while(!que.isEmpty()){
            int now = que.poll();
            for (int num : list[now]){
                if(!set.contains(num)){
                    set.add(num);
                    que.offer(num);
                }
            }
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
}