import java.util.*;
import java.io.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    int[] arr ;
    boolean[] visited;
    String numbers;
    int n, answer;
    public int solution(String numbers) {
        answer = 0;
        this.numbers = numbers;
        n = numbers.length(); 
        
        for(int i=1; i<=n; i++){
            visited = new boolean[n];
            arr = new int[i];
            combi(0,i);
        } 
        return answer;
    }
    public void combi(int depth, int max){
        if(depth==max){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<max; i++){
                sb.append(arr[i]);
            }
            if(numCheck(Integer.parseInt(sb.toString()))) answer++;
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                arr[depth]=numbers.charAt(i)-'0';
                visited[i] = true;
                combi(depth+1, max); 
                visited[i] = false;
            }
        }
        
    }
    public boolean numCheck(int num){
        if(num < 2) return false;
        if(set.contains(num)) return false;
        else {
            set.add(num);
            if(num==2 || num==3 || num==5 || num==7) return true;
            for(int i=2; i * i <= num; i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }
}