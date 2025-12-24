import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static int N, M, T;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        StringBuilder sb = new StringBuilder();
        if(T==1){
            for (int i = 0; i < N; i++) {
                sb.append(map[i]);
                sb.append('\n');
            }
        }else if(T%2==0){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append('O');
                }sb.append('\n');
            }
        }else if(T%4==3){
           char[][] answer = bomb(map);
           for (int i = 0; i < N; i++) {
               for (int j = 0; j < M; j++) {
                   sb.append(answer[i][j]);
               }sb.append('\n');
           }
        }else{
            char[][] answer = bomb(bomb(map));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(answer[i][j]);
                }sb.append('\n');
            }
        }
        System.out.println(sb);
    }
    public static char[][] bomb(char[][] map){
        char[][] returnMap = new char[N][M];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for (int i = 0; i < N; i++) {
            Arrays.fill(returnMap[i],'O');
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='O'){
                    returnMap[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<N && nc>=0 && nc<M ){
                            returnMap[nr][nc] = '.';
                        }
                    }
                }
            }
        }
        return returnMap;
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}