import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int n;
    static List<int[]> student;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        student = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'S') student.add(new int[]{i, j});
            }
        }
        dfs(0);

        System.out.println("NO");

    }

    public static void dfs(int obstacle) {
        if (obstacle == 3) {
            //체크
            if(checkTeacher()){
                System.out.println("YES");
                System.exit(0);
            };
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(obstacle + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    public static boolean checkTeacher() {
        Queue<int[]> que = new LinkedList<>();
        char[][] copyMap = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        //teacher sight check
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMap[i][j] == 'T') {
                    que.offer(new int[]{i, j});
                }
            }
        }
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0];
                int nc = now[1];

                while(true) {
                    nr += dr[i];
                    nc += dc[i];

                    //범위를 벗어난다면
                    if(nr<0||nc<0||nr>=n||nc>=n) break;

                    if(map[nr][nc]=='O') break;

                    //배열의 끝까지 도착하지 못했는데 학생을 만났
                    if(map[nr][nc]=='S') return false;

                }

            }
        }//while
        return true;
    }

    public static boolean checkStudent(boolean[][] check) {
        for (int[] nowStudent : student) {
            if (!check[nowStudent[0]][nowStudent[1]]) {
                return false;
            }
        }
        return true;
    }

    //장애물 설치가 불가능한 경우 CHECK, 무조건 장애물을 설치해야하는 부분 체크
    public static boolean checkImpossible() {
//        for (int i = 0; i < n; i++) {
//            String check = String.valueOf(map[i]);
////            System.out.println(check);
//            if(check.contains("S T") || check.contains("T S")){
//                return false;
//            } else if (check.contains("S X T")){
//                check = check.replace("S X T", " S O T");
//                map[i] = check.toCharArray();
//            } else if (check.contains("T X S")){
//                check = check.replace("T X S", "T O S");
//                map[i] = check.toCharArray();
//            }
//        }
        return true;
    }

}
