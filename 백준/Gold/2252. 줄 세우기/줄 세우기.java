import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int v = Integer.parseInt(st.nextToken());//학생
		int e = Integer.parseInt(st.nextToken());//관계
		int[] check = new int[v + 1]; // 진입차수 체크하는 배열
		List<Integer>[] list = new ArrayList[v + 1]; // 연결된 간선들을 체크하는 배열
		for (int i = 1; i < v + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			check[end]++;// 진입차수 계산하기
			list[start].add(end);// 간선 추가하기
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < v + 1; i++) {
			if (check[i] == 0) {
				queue.offer(i); // 제일 처음 진입차수가 0인 것 부터 큐에 넣기
			}
		}
		while (!queue.isEmpty()) {// 비어있지 않으면
			int done = queue.poll(); // 하나 빼주고
			sb.append(done).append(' ');// 출력하기위해 담고
			for (int j = 0; j < list[done].size(); j++) {// 연결된 간선 개수만큼 돌면서
				check[list[done].get(j)]--;// 연결된 간선들의 진입차수 -1;
				if (check[list[done].get(j)] == 0)
					queue.offer(list[done].get(j));
			}
		}
		System.out.println(sb);
	}// main

}
