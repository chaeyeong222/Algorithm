import java.util.*;

class Solution {
    // 4방향 이동
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        // 카드 종류별 위치 저장 (1~6번 카드 존재 가능)
        Map<Integer, List<int[]>> cardMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    cardMap.computeIfAbsent(board[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        // 카드 종류 순열 만들기
        List<Integer> cards = new ArrayList<>(cardMap.keySet());
        permute(board, r, c, cards, new boolean[cards.size()], new ArrayList<>(), cardMap);
        return answer;
    }

    // 순열 DFS
    private void permute(int[][] board, int r, int c, List<Integer> cards,
                         boolean[] visited, List<Integer> order,
                         Map<Integer, List<int[]>> cardMap) {
        if (order.size() == cards.size()) {
            // 모든 카드 순서 정해졌으니 실제로 제거해보기
            simulate(board, r, c, order, cardMap);
            return;
        }

        for (int i = 0; i < cards.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(cards.get(i));
                permute(board, r, c, cards, visited, order, cardMap);
                order.remove(order.size() - 1);
                visited[i] = false;
            }
        }
    }

    // 실제 카드 제거 시뮬레이션
    private void simulate(int[][] board, int r, int c, List<Integer> order,
                          Map<Integer, List<int[]>> cardMap) {
        int[][] copied = copy(board);
        int curR = r, curC = c;
        int cnt = 0;

        for (int num : order) {
            List<int[]> pos = cardMap.get(num);
            int[] p1 = pos.get(0);
            int[] p2 = pos.get(1);

            // 두 가지 순서 모두 고려 (p1→p2, p2→p1)
            int case1 = bfs(copied, curR, curC, p1[0], p1[1])
                      + bfs(copied, p1[0], p1[1], p2[0], p2[1]) + 2;

            int case2 = bfs(copied, curR, curC, p2[0], p2[1])
                      + bfs(copied, p2[0], p2[1], p1[0], p1[1]) + 2;

            if (case1 <= case2) {
                cnt += case1;
                curR = p2[0]; curC = p2[1];
            } else {
                cnt += case2;
                curR = p1[0]; curC = p1[1];
            }

            // 보드에서 해당 카드 제거
            copied[p1[0]][p1[1]] = 0;
            copied[p2[0]][p2[1]] = 0;
        }

        answer = Math.min(answer, cnt);
    }

    // BFS 최소 이동 계산
    private int bfs(int[][] board, int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) return 0;

        boolean[][] visited = new boolean[4][4];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];

            for (int i = 0; i < 4; i++) {
                // 일반 이동
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (inRange(nr, nc) && !visited[nr][nc]) {
                    if (nr == tr && nc == tc) return d + 1;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, d + 1});
                }

                // Ctrl 이동
                int[] ctrl = ctrlMove(board, r, c, i);
                nr = ctrl[0]; nc = ctrl[1];
                if (!visited[nr][nc]) {
                    if (nr == tr && nc == tc) return d + 1;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    // Ctrl 이동 (끝 or 카드 만날 때까지 직진)
    private int[] ctrlMove(int[][] board, int r, int c, int dir) {
        int nr = r, nc = c;
        while (true) {
            int tr = nr + dr[dir];
            int tc = nc + dc[dir];
            if (!inRange(tr, tc)) break;
            nr = tr; nc = tc;
            if (board[nr][nc] != 0) break; // 카드 만나면 stop
        }
        return new int[]{nr, nc};
    }

    private boolean inRange(int r, int c) {
        return r >= 0 && r < 4 && c >= 0 && c < 4;
    }

    private int[][] copy(int[][] board) {
        int[][] newBoard = new int[4][4];
        for (int i = 0; i < 4; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }
}
