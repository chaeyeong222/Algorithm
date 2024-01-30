import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] cheese;
	static boolean[][] visited;
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
			N = Integer.parseInt(br.readLine());// 한 변의 길이
			cheese = new int[N][N];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, cheese[i][j]);
					min = Math.min(min, cheese[i][j]);
				}
			} // 입력받기

			int cheeseCnt = 1; // 치즈덩어리

			for (int day = min; day <= max; day++) {
				int cnt = 0;
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] > day && !visited[i][j]) { // 치즈가 남아있고 체크하지 않았다면
							Checkk ch = new Checkk(i, j); // 체크해야할 대상, 클래스 생성해서 넣어주기
							bfs(ch, day); // bfs 탐색
							cnt++;
						}
					}
				}
				cheeseCnt = Math.max(cnt, cheeseCnt); // 갱신
			}
			System.out.println(cheeseCnt);
 
	}// main

	public static void bfs(Checkk ch, int day) {
		Queue<Checkk> que = new LinkedList<>();
		que.add(ch); // 큐에 담아주고
		visited[ch.r][ch.c] = true; // 방문체크

		while (!que.isEmpty()) { // 큐가 빌 때 까지
			Checkk check = que.poll();
			int r = check.r;
			int c = check.c;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue; // 범위 벗어나면 패스
				if (visited[nr][nc] || cheese[nr][nc] <= day)
					continue; // 이미 방문했거나 치즈먹었다면 패스

				Checkk ch2 = new Checkk(nr, nc); // 이어진 것들 큐에 넣어주기
				que.offer(ch2);
				visited[nr][nc] = true; // 방문체크
			}
		}
	}
}// class

class Checkk {
	int r;
	int c;

	public Checkk(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

}
