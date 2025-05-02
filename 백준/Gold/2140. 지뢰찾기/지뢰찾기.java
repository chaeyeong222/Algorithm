import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        // 맵 입력 처리
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        // 지뢰 위치 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Character.isDigit(map[i][j])) {
                    int cur = map[i][j] - '0';
                    check(i, j, cur);
                }
            }
        }

        // 지뢰가 놓였거나, 놓을 수 있는 칸을 카운트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*' || map[i][j] == '#') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    // 8방향 체크 함수
    public static void check(int x, int y, int cur) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 밖이면 skip
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (map[nx][ny] == '#' && cur != 0) {
                // 지뢰를 넣을 수 있다면
                cur--;
                map[nx][ny] = '*';
            } else if (map[nx][ny] == '*' && cur != 0) {
                // 이미 지뢰가 있다면
                cur--;
            } else if (map[nx][ny] == '#' && cur == 0) {
                // 지뢰를 넣을 수 없으면
                map[nx][ny] = '-';
            }
        }
    }
}
