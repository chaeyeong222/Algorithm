import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<List<int[]>> delList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        int turn = 0;
        while(true){
            puyoCheck(); //터지는지 체크 > 터진다면 터지는 애들 list 반환
            if(delList.size()==0) break;
            delete(); //터뜨리기
            makeNewMap();//새로운 리스트로 만들어서 아래로 떨어지고, 이후 다시
            turn++;
            delList = new ArrayList<>();
        }
        System.out.println(turn);
    }
    public static void makeNewMap(){
        HashMap<Integer, List<Character>> charList = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            List<Character> t = new ArrayList<>();
            for (int j = 11; j >=0; j--) {
                if(map[j][i]!='.'){
                    t.add(map[j][i]);
                }
            }
            charList.put(i,t);
        }

        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            Arrays.fill(map[i], '.');
        }
        for (int i = 0; i < 6; i++) {
            int idx = 11;
            for(char j : charList.get(i)){
                map[idx][i] = j;
                idx--;
            }
        }
    }
    public static void delete(){
        for(List<int[]> l : delList){
            for (int i = 0; i < l.size(); i++) {
                int rr = l.get(i)[0];
                int cc = l.get(i)[1];
                map[rr][cc] = '.';
            }
        }
    }
    public static void puyoCheck(){
        visited = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if(map[i][j]!='.' && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }
    }
    public static void bfs(int r, int c){
        char pivot = map[r][c];
        int cnt = 1;
        boolean[][] visit = new boolean[12][6];
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{r,c});
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        visit[r][c] = true;
        visited[r][c] = true;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = temp[0]+dr[i];
                int nc = temp[1]+dc[i];
                if(nr>=0 && nr<12 && nc>=0 && nc<6 && !visit[nr][nc] && map[nr][nc]==pivot){
                    cnt++;
                    visit[nr][nc] = true;
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr,nc});
                    list.add(new int[]{nr,nc});
                }
            }
        }
        if(cnt>=4){
            delList.add(list);
        }
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

}