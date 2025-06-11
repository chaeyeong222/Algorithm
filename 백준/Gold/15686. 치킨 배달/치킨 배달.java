import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<int[]> chicken;
    static boolean[] visited;
    static List<int[]> house;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        trace(0, 0);
        System.out.println(answer);
    }
    public static void trace(int idx, int cnt) {
        if (cnt == M) { 
            checkDistance();
            return;
        }
        if (idx == chicken.size()) return; // 인덱스 초과 시 종료

        // 현재 치킨집을 선택하는 경우
        visited[idx] = true;
        trace(idx + 1, cnt + 1);

        // 선택하지 않는 경우
        visited[idx] = false;
        trace(idx + 1, cnt);
    }
    public static void checkDistance(){ // 완성된 map 으로 거리 테스트
        int sum = 0;
        for(int[] hList : house){
            int min = Integer.MAX_VALUE;
             int r = hList[0];
             int c = hList[1];
             for(int i=0; i<chicken.size(); i++){
                 if(visited[i]) {
                     int[] chick = chicken.get(i);
                     int rr = chick[0];
                     int cc = chick[1];
                     int distance = Math.abs(r - rr) + Math.abs(c - cc);
                     min = Math.min(min, distance);
                 }
             }
             sum+=min;
             if(sum >= answer) return;
        }
        answer = Math.min(sum, answer); //갱신
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    chicken.add(new int[]{i,j});
                }else if(map[i][j]==1){
                    house.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;
    }
}