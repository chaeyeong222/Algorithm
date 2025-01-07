import java.io.*;
import java.util.*;
class Main {
    static int N,K;
    static List<Integer>[] buildings;
    static int[] indegree;
    static int[] time;
    static StringBuilder sb;
    static int goal;
    static int[] done;
    static int cnt;
    public static void main(String[] args) throws Exception {
        set();
        System.out.println(sb);
    }
    public static void pro(){
        Deque<Integer> que = new LinkedList<>();
        for (int i = 1; i < N+1; i++) { //먼저 작업이 가능한 건물들 que에 넣어줌
            if(indegree[i]==0) {
                que.add(i);
                done[i]=time[i];
            }
        }
        while(!que.isEmpty()){
            int now = que.poll();
            for(int next : buildings[now]){
                indegree[next]--;
                if(indegree[next]==0){
                    que.add(next);
                }
                done[next] = Math.max(done[next], done[now]+time[next]); //
            }
        }
        sb.append(done[goal]).append('\n');


    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        StringTokenizer st;
        for (int TC = 0; TC < T; TC++) { //tc 횟수
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //건물개수
            K = Integer.parseInt(st.nextToken()); //규칙개수
            buildings = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) {  //건물1부터 시작
                buildings[i] = new ArrayList<>();
            }
            time = new int[N+1]; //소요시간
            done = new int[N+1]; //소요시간
            indegree = new int[N+1]; //선작업 건물 개수
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N+1; i++) { //1부터 채움
                time[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) { //규칙 num1 이후 num2 작업가능
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                buildings[num1].add(num2);
                indegree[num2]++;
            }
            goal = Integer.parseInt(br.readLine()); //완료 기준 = 건설완료 건물
            pro();
        }//TC
    }
}