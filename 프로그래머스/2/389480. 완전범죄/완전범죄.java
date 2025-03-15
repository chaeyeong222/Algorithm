import java.util.*;

class Solution {
    static int[][] info;
    static int n, m;
    static int totalLength;
    static int answer;
    static boolean[][][] memo; // 메모이제이션 추가

    public int solution(int[][] info, int n, int m) {
        answer = Integer.MAX_VALUE;
        this.info = info;
        this.n = n;
        this.m = m;
        totalLength = info.length;
        
        // memo 배열 크기 설정: idx, A, B
        // A가 n을 넘지 않도록, B가 m을 넘지 않도록 조정
        memo = new boolean[totalLength + 1][n + 1][m + 1]; // A, B가 n, m을 초과하지 않도록

        steal(0, 0, 0);
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    public static void steal(int idx, int A, int B) {
        // A, B 도둑이 한계 초과하면 종료
        if (A >= n || B >= m) return;  // A나 B가 조건을 초과한 경우, 더 이상 탐색할 필요 없음
        if (idx == totalLength) {
            if (A < n) {
                answer = Math.min(answer, A); // 최소 A 흔적 저장
            }
            return;
        }

        // 이미 방문한 상태라면 다시 탐색하지 않음
        if (memo[idx][A][B]) return;
        memo[idx][A][B] = true; // 방문 처리

        // A가 훔치는 경우
        steal(idx + 1, Math.min(A + info[idx][0], n), B);
        // B가 훔치는 경우
        steal(idx + 1, A, Math.min(B + info[idx][1], m));
    }
}
