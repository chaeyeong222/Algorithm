import java.util.*;
import java.io.*;
class Solution {
    static List<String[]> list;
    static int answer;
    static int idx;
    public int solution(int cacheSize, String[] cities) {
        answer = 0;
        idx = 0;
        list = new ArrayList<>();
        for(int i=0; i<cities.length; i++){
            //1. 이미 캐시에 있는 지 체크
            boolean flag = checkCache(cities[i]); //true 라면 이미 조치함
            if(!flag){ //캐시에 없다면 캐시 사이즈 체크
                if(list.size()<cacheSize){
                    //캐시 사이즈가 남아있다면
                    answer+=5; //
                    list.add(new String[]{cities[i].toUpperCase(), idx++ +""});
                }else{ //하나를 제외해야 한다면
                    //정렬해서 가장 idx 가 작은 수를 없앤다.
                    
                    Collections.sort(list, new Comparator<String[]>(){
                        @Override
                        public int compare(String[] o1, String[] o2){
                            return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                        }
                    });
                    if(cacheSize!=0){
                        list.remove(0);
                        list.add (new String[]{cities[i].toUpperCase(), idx++ +""});
                    }
                    answer+=5;   
                } 
            } 
        }
        return answer;
    }
    public boolean checkCache(String city){ //캐시에 있는지 체크
        for(int i=0; i<list.size(); i++){
            if(list.get(i)[0].equals(city.toUpperCase())){
                //있으면 해당 값의 인덱스 바꿔줘야함. + 1 더해주기
                answer+=1;
                list.get(i)[1] = idx++ +"";// idx 값 바꿔주고 하나 더해줌
                return true;
            }
        }
        return false;
    }
}