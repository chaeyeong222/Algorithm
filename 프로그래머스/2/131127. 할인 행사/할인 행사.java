import java.util.*;
import java.io.*; 
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0; 
        Map<String, Integer> wish = new HashMap<>();
        for(int i=0;i<want.length;i++){
            wish.put(want[i], number[i]);
        }
        for(int i=0; i<discount.length - 10 + 1; i++){
            //현재기준 구매할 수 있는 상품을 넣을 map
            Map<String, Integer> disProduct = new HashMap<>();
            for(int j=0; j< 10; j++){
                disProduct.put(discount[i+j], disProduct.getOrDefault(discount[i+j],0)+1);
            }
            //모든 상품을 구매할 수 있는지 체크
            boolean possible=true;
            for(String key : wish.keySet()){
                if(wish.get(key) != disProduct.get(key)){
                    possible = false;
                    break;
                }
            }
            //구매가능하면 그 날짜 더해줌
            answer += possible?1:0;
            
        }//for
        
        return answer;
    }
}