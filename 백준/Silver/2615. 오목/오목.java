import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    //가로, 세로, 대각선오른쪽위, 대각선오른쪽아래
    static int[] dr = {0, 1, -1, 1};
    static int[] dc = {1, 0, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[19][19];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//

        boolean flag = true;

        out:
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[j][i] == 1 || map[j][i] == 2) {
                    if (check(j, i, map[j][i])) {
                        System.out.println(map[j][i]);
                        System.out.println((j + 1) + " " + ( i + 1));
                        flag = false;
                        break out;
                    }
                }
            }
        }//

        if (flag) System.out.println(0);
    } //main

    public static boolean check(int r, int c, int value) {

        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            int nr = r;
            int nc = c;
            while (true) {
                if (nr >= 0 && nc >= 0 && nr < 19 && nc < 19 && map[nr][nc] == value) {
                    nr += dr[i];
                    nc += dc[i];
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == 5) {
                // 시작지점이 아닌경우
                if (r - dr[i] >= 0 && r - dr[i] < 19 && c - dc[i] >= 0 && c - dc[i] < 19 && map[r - dr[i]][c - dc[i]] == value) {
                    return false;
                }
//                System.out.println("r"+r+"c"+c);
                return true;
            }
        }
        return false;
    }
}