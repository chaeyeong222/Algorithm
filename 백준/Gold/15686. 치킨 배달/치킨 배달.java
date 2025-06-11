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
            // M개 선택 완료 -> 거리 계산
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                temp[i] = map[i].clone();
            }
            for (int i = 0; i < chicken.size(); i++) {
                if (!visited[i]) {
                    int[] remove = chicken.get(i);
                    temp[remove[0]][remove[1]] = 0;
                }
            }
            checkDistance(temp);
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
    public static void checkDistance(int[][] cloneMap){ // 완성된 map 으로 거리 테스트
        int sum = 0;
        for(int[] hList : house){
            Queue<int[]> que = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            que.offer(new int[]{hList[0],hList[1]});
            visited[hList[0]][hList[1]]=true;
            while(!que.isEmpty()){
                if(sum>answer) return; //중간에 넘치면 끝
                int[] now = que.poll();
                if(cloneMap[now[0]][now[1]]==2){
                    sum += Math.abs(hList[0]-now[0])+Math.abs(hList[1]-now[1]);
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = now[0]+dr[i];
                    int nc = now[1]+dc[i];
                    if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]){
                        que.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
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