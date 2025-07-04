import java.util.*;

class Solution {
    static Map<String, Integer> combinationCnt;
    static List<String> answer;

    public ArrayList<String> solution(String[] orders, int[] course) { 
        answer = new ArrayList<>();
        
        for(int len : course){
            int max = 0;
            combinationCnt = new HashMap<>();
            for(String order : orders){
                char[] alpha = order.toCharArray();
                Arrays.sort(alpha);
                makeCombi(alpha, new StringBuilder(), 0, len);
            }
            
            //가장 많이 나온 조합 찾기
            
            for( Map.Entry<String,Integer> entry : combinationCnt.entrySet()){
                int cnt = entry.getValue();
                if(cnt>=2){
                    max = Math.max(cnt, max);
                }
            }
            for( Map.Entry<String,Integer> entry : combinationCnt.entrySet()){
                if (entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
            
        }
        Collections.sort(answer); // 최종 결과 정렬
        return new ArrayList<>(answer);
    }
    public void makeCombi(char[] alpha, StringBuilder sb, int idx, int targetLen ){
        if(sb.length()==targetLen){
            String temp = sb.toString();
            combinationCnt.put(temp, combinationCnt.getOrDefault(temp, 0)+1);
            return;
        }
        for(int i=idx; i<alpha.length; i++){
            sb.append(alpha[i]);
            makeCombi(alpha, sb, i+1, targetLen);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
