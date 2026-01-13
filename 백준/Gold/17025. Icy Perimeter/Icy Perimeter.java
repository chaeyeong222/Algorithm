import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static List<IceCream> list;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j]!='.') {
                    getGroupInfo(i,j);
                }
            }
        }
        int maxArea = 0;
        int minLength = Integer.MAX_VALUE;
        for(IceCream c: list){
            if(c.area > maxArea){
                maxArea = c.area;
                minLength = c.length;
            }else if(c.area==maxArea){
                minLength = Math.min(c.length, minLength);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxArea).append(' ').append(minLength);
        System.out.println(sb);
    }

    public static void getGroupInfo(int r, int c){
        visited[r][c] = true;
        int cnt = 1;
        int len = 0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        while(!que.isEmpty()){
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=N) len++;
                else if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]=='.') len++;

                if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]=='#' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    cnt++;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
        list.add(new IceCream(cnt, len));
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}
class IceCream{
    int area;
    int length;
    public IceCream(int area, int length){
        this.area = area;
        this.length = length;
    }
}