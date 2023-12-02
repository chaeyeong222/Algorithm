import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1){
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    public static int bfs(int r, int c){
        int cnt=0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        map[r][c]=0;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int tempR = temp[0];
            int tempC = temp[1];
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nr = tempR+dr[i];
                int nc = tempC+dc[i];
                //범위내에 있으면
                if(nr<n &&  nr >=0 && nc<n && nc>=0 && map[nr][nc]==1){
                    //넣어줌
                    que.offer(new int[]{nr, nc});
                    map[nr][nc]=0;//방문처리
                }
            }//
        }
        return cnt;
    }
}
