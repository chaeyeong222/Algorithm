import java.util.*;

class Solution {
    static Map<String, Integer> combinationCount;
    static List<String> answer;

    public ArrayList<String> solution(String[] orders, int[] course) {
        answer = new ArrayList<>();

        for (int len : course) {
            combinationCount = new HashMap<>();
            int maxCount = 0;

            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr); // 사전 순 정렬 필수

                getCombinations(arr, new StringBuilder(), 0, len);
            }

            // 가장 많이 나온 조합 찾기
            for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
                int count = entry.getValue();
                if (count >= 2) {
                    maxCount = Math.max(maxCount, count);
                }
            }

            for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
                if (entry.getValue() == maxCount) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer); // 최종 결과 정렬
        return new ArrayList<>(answer);
    }

    // 조합 생성
    private void getCombinations(char[] arr, StringBuilder sb, int idx, int targetLen) {
        if (sb.length() == targetLen) {
            String combo = sb.toString();
            combinationCount.put(combo, combinationCount.getOrDefault(combo, 0) + 1);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            getCombinations(arr, sb, i + 1, targetLen);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
