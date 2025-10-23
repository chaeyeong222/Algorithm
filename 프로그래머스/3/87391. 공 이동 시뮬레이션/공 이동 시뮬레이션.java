import java.util.*;

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long r1 = x; // 행 범위 시작
        long r2 = x; // 행 범위 끝
        long c1 = y; // 열 범위 시작
        long c2 = y; // 열 범위 끝

        // 쿼리를 역순으로 처리
        for (int i = queries.length - 1; i >= 0; i--) {
            int order = queries[i][0];
            long dx = queries[i][1]; // dx를 long으로 캐스팅

            if (order == 0) {
                c1 = (c1 == 0) ? 0 : c1 + dx;
                c2 = Math.min(m - 1, c2 + dx);
            } else if (order == 1) { 
                c1 = Math.max(0, c1 - dx);
                c2 = (c2 == m - 1) ? m - 1 : c2 - dx;
            } else if (order == 2) { 
                r1 = (r1 == 0) ? 0 : r1 + dx;
                r2 = Math.min(n - 1, r2 + dx);
            } else {
                r1 = Math.max(0, r1 - dx);
                r2 = (r2 == n - 1) ? n - 1 : r2 - dx;
            }

            if (r1 > r2 || c1 > c2) {
                return 0;
            }
            
            r1 = Math.max(0, r1);
            r2 = Math.min(n - 1, r2);
            c1 = Math.max(0, c1);
            c2 = Math.min(m - 1, c2);

            if (r1 > r2 || c1 > c2) {
                return 0;
            }
        }

        return (r2 - r1 + 1) * (c2 - c1 + 1);
    }
}