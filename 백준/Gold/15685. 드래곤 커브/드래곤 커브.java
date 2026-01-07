import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Dragon> dragons;
    static int[][] map;
    static int[] dr = {0,-1,0,1}; //우 상 좌 하
    static int[] dc = {1,0,-1,0}; 
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        for (int i = 0; i < N; i++) {
            // 드래곤커브 대상좌표 체크
            Dragon now = dragons.get(i);
            List<Integer> dirList = curveCheck(now);

            // 모양 그리기
            drawDragon(now, dirList);

        }
        //정사각형 체크
        System.out.println(countSqaure());
    }
    public static int countSqaure(){
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j]==1){
                    if(checkSqaure(i,j)) cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean checkSqaure(int r, int c){
        return map[r][c]==1 && map[r+1][c]==1 && map[r][c+1]==1 &&map[r+1][c+1]==1;
    }
    public static void drawDragon(Dragon d, List<Integer> dirList){
        int r = d.r;
        int c = d.c;
        map[r][c] = 1;
        for(int next : dirList){
            r+=dr[next];
            c+=dc[next];
            map[r][c] = 1;
        }
    }

    public static List<Integer> curveCheck(Dragon d){
        int gen = d.gen;
        int dir = d.dir;
        List<Integer> list = new ArrayList<>();
        list.add(dir);
        int now = 0;
        while(now<gen){
            int n = list.size();
            for (int i = n-1; i >= 0 ; i--) {
                int next = list.get(i);
                list.add((next+1)%4);
            }
            now++;
        }
        return list;
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dragons = new ArrayList<>();
        map = new int[101][101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());
            dragons.add(new Dragon(y,x,d,gen));
        }
    }
}
class Dragon{
    int r;
    int c;
    int dir;
    int gen;
    Dragon(int r, int c, int dir, int gen){
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.gen = gen;
    }
}
