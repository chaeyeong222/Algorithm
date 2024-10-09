import java.util.*;
import java.io.*;
class Solution {
    public  List<Integer> solution(String s) { 
        //길이가 작은 순서대로 나오지 않은 숫자를 담아준다. 
        String[] temp = s.split("},");//구분하여 배열에 담는다
        for(int i=0; i<temp.length; i++ ){
            temp[i] = temp[i].replace("{",""); //필요없는 문자를 제거한다
            temp[i] = temp[i].replace("}","");
        }
        Arrays.sort(temp, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.length()-o2.length();
            }
        }); //크기순으로 정렬한다 
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<temp.length; i++){
            String[] tt = temp[i].split(","); //숫자별로 구분한다
            for(int j=0; j<tt.length; j++){ //담기지 않은 숫자를 리스트에 담아준다.
                int num = Integer.parseInt(tt[j]);
                if(!list.contains(num)) list.add(num);
            }
        }
        
        return list;
    }
}