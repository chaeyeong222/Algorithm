import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int prev = people[0];
        int n = people.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            if(people[left]+people[right]>limit){
                right--;
                answer++;
            }else{
                answer++;
                left++;
                right--; 
            }
        }
        return answer;
    }
}