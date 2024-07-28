import java.util.*;
import java.io.*; 
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wishList = new HashMap<>();
        for(int i=0; i<want.length; i++){ 
            wishList.put(want[i], number[i]);
        } 
        for(int i=0; i<discount.length-10+1; i++){
            Map<String, Integer> product = new HashMap<>();
            for(int j=0; j<10; j++){
                 product.put(discount[i+j],product.getOrDefault(discount[i+j],0)+1);
            }
            boolean flag = true;
            for(String key : wishList.keySet()){
                if(wishList.get(key) != product.get(key)){
                    flag = false;
                    break;
                }
            }
            if(flag) answer+=1;
        }
        return answer;
    }
}