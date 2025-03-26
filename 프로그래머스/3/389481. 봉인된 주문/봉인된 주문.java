import java.util.*;
import java.io.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        Queue<String> que = new LinkedList<>();
        Arrays.sort(bans, new Comparator<String>(){
           @Override
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o1.length()-o2.length();
            }
        });
        
        for(String check : bans){
            String target = makeString(n);
            if(check.length() < target.length() || check.length()==target.length() && check.compareTo(target) <=0 ) {
                n++;
            }else{
                break;
            }
        }
        
        return makeString(n);
    }
    public String makeString(long n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            long remain = n%26;
            n/=26;
            if(remain==0){
                n--;
                sb.append('z');
            }else{
                sb.append((char)('a'+remain-1));
            }
        } 
        return sb.reverse().toString();
    }
}