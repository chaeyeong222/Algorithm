import java.io.*;
import java.util.*;
//## 알파벳
class Main {
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int r, c;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[26];
        answer = 0;
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        
        if(r==1 && c==1){
            System.out.println(1);
        }else {
            find(0, 0, 0);

            System.out.println(answer);
        }

    }
    public static void find(int nowR, int nowC, int cnt){
        //탈출조건
        if(visited[map[nowR][nowC]]){
            answer = Math.max(answer, cnt);
            return;
        }
        visited[map[nowR][nowC]] = true;
        for (int i = 0; i < 4; i++) {
            int nr = nowR + dr[i];
            int nc = nowC + dc[i];
            if(nr>=0 && nr<r && nc>=0 && nc<c){
                find(nr, nc, cnt+1);
            }
        }
        visited[map[nowR][nowC]] = false;
    }
}