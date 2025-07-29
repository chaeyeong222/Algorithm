class Solution {
    public int solution(String s) {
        int minLength = s.length();

        for (int size = 1; size <= s.length() / 2; size++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, size);
            int count = 1;

            for (int j = size; j <= s.length(); j += size) {
                String current;
                if (j + size <= s.length()) {
                    current = s.substring(j, j + size);
                } else {
                    current = s.substring(j); // 남은 부분
                }

                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count).append(prev);
                    } else {
                        compressed.append(prev);
                    }
                    prev = current;
                    count = 1;
                }
            }

            // 마지막 처리
            if (count > 1) {
                compressed.append(count).append(prev);
            } else {
                compressed.append(prev);
            }

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}
