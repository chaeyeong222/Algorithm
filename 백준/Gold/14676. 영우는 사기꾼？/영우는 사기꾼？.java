import java.io.*;
import java.util.*;
class Main {
    static int N,M, K;
    static List<Integer>[] list;
    static int[] indegree;
    static int[] build;
    static BufferedReader br;
    static StringTokenizer st;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        if(flag){
            System.out.println("King-God-Emperor");
        }else{ System.out.println("Lier!");}

    }
    public static void pro() throws Exception{
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(order==1){ //새로 세우기
                if(indegree[num]==0){ // 세울 수 있음
                    build[num]++;
                    if(build[num]==1){
                        for(int next : list[num]){
                            indegree[next]--;
                        }
                    }

                }else{
                    flag = false;
                    return;
                }
            }else if (order == 2) { // 파괴 명령
                if (build[num] > 0) { // 건설된 상태라면 파괴 가능
                    build[num]--;
                    if (build[num] == 0) { // 마지막 건물이 파괴될 때만
                        for (int next : list[num]) {
                            indegree[next]++;
                        }
                    }
                } else { // 건설된 적이 없는 건물을 파괴하려고 함
                    flag = false;
                    return;
                }
            }
        }

    }

    static void set() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        indegree = new int[N+1];
        build = new int[N+1];

        flag = true;
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            indegree[next]++;
            list[prev].add(next);
        }
    }
}