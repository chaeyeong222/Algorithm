import java.util.*;

class Solution {
    static char[][] word;
    static boolean[][] visited;
    static int N, M;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        set(storage); // 창고 데이터 세팅

        for (String request : requests) {
            check(request);
        }

        // 남아 있는 컨테이너 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (word[i][j] != '.') {
                    answer++;
                }
            }
        }

        return answer;
    }

    public void check(String request) {
        char target = request.charAt(0);
        if (request.length() == 1) { // 지게차 사용
            markOutsideSpaces(); // BFS를 사용해 외부와 연결된 공간 탐색
            List<int[]> removeList = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (word[i][j] == target && rangeCheck(i, j)) {
                        removeList.add(new int[]{i, j});
                    }
                }
            }

            for (int[] pos : removeList) {
                word[pos[0]][pos[1]] = '.';
            }
        } else { // 크레인 사용 (모든 해당 컨테이너 제거)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (word[i][j] == target) {
                        word[i][j] = '.';
                    }
                }
            }
        }
    }

    public boolean rangeCheck(int r, int c) {
        if (r == 0 || c == 0 || r == N - 1 || c == M - 1) return true; // 가장자리 컨테이너는 제거 가능
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc]) return true; // 외부와 연결된 공간이면 제거 가능
        }
        return false;
    }

    public void markOutsideSpaces() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][M];

        // 가장자리에서 시작하여 외부와 연결된 빈 공간 탐색
        for (int i = 0; i < N; i++) {
            if (word[i][0] == '.') queue.add(new int[]{i, 0});
            if (word[i][M - 1] == '.') queue.add(new int[]{i, M - 1});
        }
        for (int j = 0; j < M; j++) {
            if (word[0][j] == '.') queue.add(new int[]{0, j});
            if (word[N - 1][j] == '.') queue.add(new int[]{N - 1, j});
        }

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && word[nr][nc] == '.') {
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    public void set(String[] storage) {
        N = storage.length;
        M = storage[0].length();
        word = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            word[i] = storage[i].toCharArray();
        }
    }
}
