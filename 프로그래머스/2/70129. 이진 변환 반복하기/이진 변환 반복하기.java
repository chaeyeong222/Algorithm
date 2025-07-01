import java.util.*;
import java.io.*;

class Solution {
    public String pivot;
    public int[] numCnt;
    public int[] answer = new int[2];
    
    public int[] solution(String s) {
        this.pivot = s; 
        checkZero();
        while(!pivot.equals("1")){
            answer[0]++;//횟수 추가
            //2진수변환
            pivot = toBinary();
            //0개수 체크
            checkZero();
        }
        return answer;
    }
    public String toBinary(){
        int number = numCnt[1];
        StringBuilder sbd = new StringBuilder();
        while(number>0){
            sbd.append(number%2);
            number/=2;
        } 
        return sbd.reverse().toString();
    }
    
    public void checkZero(){
        numCnt = new int[2];
        for(char x : pivot.toCharArray()){
            if(x=='0'){
                numCnt[0]++;
            }else{
                numCnt[1]++;
            }
        } 
        answer[1]+=numCnt[0]; //제거할 0의 개수
    }
}