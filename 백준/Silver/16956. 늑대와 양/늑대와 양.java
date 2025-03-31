import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        if(!flag){
            sb.append(0);
        }else{
            sb.append(1).append('\n');
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(map[i][j]);
                }sb.append('\n');
            }
        }
        System.out.println(sb);
    }
    public static void pro() {
        flag = true;
        out: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]=='W'){
                    flag = findS(i,j);
                    if(!flag) return;
                }
            }
        }

    }
    public static boolean findS(int r, int c ){ 
        //바로 붙어 있으면 불가능
        for (int i = 0; i < 4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if(rr>=0 && cc>=0 && rr<n && cc<m){
                if(map[rr][cc]=='S'){
                    return false;
                }else if(map[rr][cc]=='.'){
                    map[rr][cc] = 'D';
                }
            }
        } 
        return true;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
    }
}
