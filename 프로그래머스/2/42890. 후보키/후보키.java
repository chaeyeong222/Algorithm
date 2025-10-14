import java.util.*;
import java.io.*;
class Solution {
    List<Integer> usableIdx = new ArrayList<>();
    String[][] relation; 
    int n;
    int[] arr;
    List<Set<Integer>> candidateKeys = new ArrayList<>();
    public int solution(String[][] relation) {
        this.relation = relation;
        n = relation[0].length;
        for(int i=0; i<n; i++){
            usableIdx.add(i);
        }
        //조합
        for(int i=1; i<=n; i++){
            arr = new int[i]; 
            combination(0,0,i);
        }
        
        return candidateKeys.size();
    }
    public void combination(int start, int depth, int max){ 
        if(depth==max){
            //체크후
            uniqueCheck(arr);
            return;//
        } 
        for(int i=start; i< usableIdx.size(); i++){
            arr[depth] = usableIdx.get(i);
            combination(i+1, depth+1, max); 
        }
    }
    
    public void uniqueCheck(int[] arr){
        Set<String> temp = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int col : arr) {
                sb.append(relation[i][col]);
            }
            temp.add(sb.toString());
        }
        
        if (temp.size() != relation.length) {
            return;
        }  
        
        Set<Integer> now = new HashSet<>();
        for(int col : arr) now.add(col);
        
        for(Set<Integer> key : candidateKeys){
            if(now.containsAll(key)) return;
        }
        candidateKeys.add(now);
    }
} 

