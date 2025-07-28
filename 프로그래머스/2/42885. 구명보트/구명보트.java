import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);//정렬
        int left = 0;
        int right = people.length-1;
        while(left<=right){
            if((people[left]+people[right])>limit){
                answer++;
                right--;
            }else{
                answer++;
                left++;
                right--;
            }
        }
        return answer;
    }
}