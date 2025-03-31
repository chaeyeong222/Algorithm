import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 행 개수
        int M = sc.nextInt(); // 열 개수
        sc.nextLine(); // 버퍼 비우기

        Map<String, Integer> patternCount = new HashMap<>(); // 패턴별 개수 저장
        List<Integer> zeroCounts = new ArrayList<>(); // 각 행의 0 개수 저장

        // 램프 상태 입력 받기
        for (int i = 0; i < N; i++) {
            String row = sc.nextLine(); // 현재 행
            patternCount.put(row, patternCount.getOrDefault(row, 0) + 1); // 패턴 등장 횟수 저장
        }

        int K = sc.nextInt(); // 스위치 누를 횟수
        int maxRows = 0;

        // 가능한 최대 켜진 행 수 찾기
        for (String pattern : patternCount.keySet()) {
            int zeroCount = 0;
            for (char c : pattern.toCharArray()) {
                if (c == '0') zeroCount++;
            }

            // 조건: 0 개수가 K보다 작거나 같아야 하며, (K - 0의 개수)가 짝수여야 함
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                maxRows = Math.max(maxRows, patternCount.get(pattern));
            }
        }

        System.out.println(maxRows);
    }
}
