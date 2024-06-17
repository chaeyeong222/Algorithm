import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        //a,b는 토핑의 종류 , 만약 a와 b의 사이즈가 같으면 공평
        int A = 1;
        int B = 0;
        //countA, countB는 개수 체크
        int[] countA = new int[10001]; 
        int[] countB = new int[10001];
        countA[topping[0]]++;
        
        //동생이 가지는 토핑 체크
        for(int i=1; i<topping.length; i++){
            countB[topping[i]]++;
        }
        //토핑 종류 주머니에 담는다
        for(int i=0; i<countB.length; i++){
            if(countB[i]!=0) B++;
        }
        
        //사이즈가 같은지 비교
        for(int i=1; i<topping.length; i++){
            int candy = topping[i]; //현재 기준이 되는 곳, 여기까지 철수꺼
            //철수 먼저 체크
            if(countA[candy]==0){ // 없는애라면
                A++;
                countA[candy]++;
            }
            //동생꺼에서 제외
            if(countB[candy]-1==0){ //이제 더이상 없는 종류라면
                B--;
                countB[candy]--;
            }else if(countB[candy]-1>0){
                countB[candy]--;
            }
            
            if(A==B){
                answer++;
            }
        }
        return answer;
    }
}