import java.util.*;
import java.io.*;

class Solution {
    Map<Integer, Integer> result; // 총시간
    static int[] fees;
    public int[] solution(int[] fees, String[] records) { 
        this.fees = fees;
        result = new HashMap<>(); 
        HashMap<String, Integer> map = new HashMap<>(); //temp
        for(String record : records){
            String[] info = record.split(" "); 
            int time = timeToNum(info[0]);
            String type = info[2];
            if(type.equals("IN")){//그냥 넣어줘
                map.put(info[1], timeToNum(info[0]));
            }else{//있는거 더해서 결과에 넣어줌
                int tempTime = time - map.get(info[1]);
                int CarNum = Integer.parseInt(info[1]);
                if(result.containsKey(CarNum)){
                    result.put(CarNum, result.get(CarNum)+tempTime);
                }else{
                    result.put(CarNum, tempTime);
                }
                map.remove(info[1]);
            }  
        }//foreach  
        
        //출차안한애들계산 
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int outTime = timeToNum("23:59");
            int inTime = entry.getValue(); // 입차 시간
            int CarNum = Integer.parseInt(entry.getKey());
            int parkedTime = outTime - inTime; //  
            result.put(CarNum, result.getOrDefault(CarNum, 0) + parkedTime);  
        } 
        
        //정렬
        List<Integer> keySet = new ArrayList<>(result.keySet());
        Collections.sort(keySet);
        int[] answer = new int[result.size()];
        int idx = 0;
        for(int k : keySet){
            answer[idx++] = calFee(result.get(k));
        }
        return answer;
    }
    public int timeToNum(String time){ // 시간을 숫자로
        String[] num = time.split(":");
        int total = 0;
        total += Integer.parseInt(num[0])*60;
        total += Integer.parseInt(num[1]);
        return total;
    }
    public int calFee(int in){ //총 금액 계산
        int totalTime = in;
        int charge = 0;
        if (totalTime <= fees[0]) { return fees[1]; }
        
        // 초과 시간 계산
        int extraTime = totalTime - fees[0];
        int units = (int) Math.ceil((double) extraTime / fees[2]);
        return fees[1] + units * fees[3];
        }//
}