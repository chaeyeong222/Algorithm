import java.util.*;

class Solution {
    // 숫자 패드의 좌표 (1~9, 0)
    static int[][] pos = {
        {3, 1}, // 0
        {0, 0}, {0, 1}, {0, 2}, // 1, 2, 3
        {1, 0}, {1, 1}, {1, 2}, // 4, 5, 6
        {2, 0}, {2, 1}, {2, 2}  // 7, 8, 9
    };
    
    // 두 숫자 간의 최소 이동 가중치 계산
    static int getCost(int from, int to) {
        if (from == to) return 1;
        
        int[] fromPos = pos[from];
        int[] toPos = pos[to];
        
        int dx = Math.abs(fromPos[0] - toPos[0]);
        int dy = Math.abs(fromPos[1] - toPos[1]);
        
        // 대각선 이동 + 직선 이동
        int diagonal = Math.min(dx, dy);
        int straight = Math.abs(dx - dy);
        
        return diagonal * 3 + straight * 2;
    }
    
    public int solution(String numbers) {
        int n = numbers.length();
        int[] nums = new int[n];
        
        // 문자열을 숫자 배열로 변환
        for (int i = 0; i < n; i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        // dp[left][right] = 왼손이 left, 오른손이 right에 있을 때의 최소 가중치
        int[][] dp = new int[10][10];
        int[][] newDp = new int[10][10];
        
        // 초기화
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            Arrays.fill(newDp[i], Integer.MAX_VALUE);
        }
        
        dp[4][6] = 0; // 초기 상태: 왼손 4, 오른손 6
        
        // 각 숫자를 입력
        for (int i = 0; i < n; i++) {
            int target = nums[i];
            
            // 초기화
            for (int j = 0; j < 10; j++) {
                Arrays.fill(newDp[j], Integer.MAX_VALUE);
            }
            
            // 모든 상태에서 전이
            for (int left = 0; left < 10; left++) {
                for (int right = 0; right < 10; right++) {
                    if (dp[left][right] == Integer.MAX_VALUE) continue;
                    
                    // 왼손으로 target을 누르는 경우
                    if (right != target) { // 오른손이 target에 없으면
                        int cost = dp[left][right] + getCost(left, target);
                        newDp[target][right] = Math.min(newDp[target][right], cost);
                    }
                    
                    // 오른손으로 target을 누르는 경우
                    if (left != target) { // 왼손이 target에 없으면
                        int cost = dp[left][right] + getCost(right, target);
                        newDp[left][target] = Math.min(newDp[left][target], cost);
                    }
                    
                    // target 위에 손가락이 이미 있는 경우
                    if (left == target) {
                        int cost = dp[left][right] + 1;
                        newDp[target][right] = Math.min(newDp[target][right], cost);
                    }
                    if (right == target) {
                        int cost = dp[left][right] + 1;
                        newDp[left][target] = Math.min(newDp[left][target], cost);
                    }
                }
            }
            
            // dp 업데이트
            int[][] temp = dp;
            dp = newDp;
            newDp = temp;
        }
        
        int answer = Integer.MAX_VALUE;
        for (int left = 0; left < 10; left++) {
            for (int right = 0; right < 10; right++) {
                answer = Math.min(answer, dp[left][right]);
            }
        }
        
        return answer;
    } 
}