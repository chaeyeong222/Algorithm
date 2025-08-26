import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static boolean[] visited;
    static int[][] dice;
    static double maxWinProb = -1;
    static int[] bestChoice;
    
    public int[] solution(int[][] diceInput) {
        
        maxWinProb = -1;
        dice = diceInput;
        N = dice.length;
        bestChoice = new int[N/2];
        visited = new boolean[N];
        pickDice(0,0);
        
        return bestChoice;
    }
    public void pickDice(int depth , int cnt){
        if(cnt==N/2){
            //주사위선택완료 > 승무패 체크 
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>(); 
            for(int i=0; i<N; i++){
                if(visited[i]){
                    A.add(i);
                }else{
                    B.add(i);
                }
            }
            calScore(A,B); //스코어계산
            return;
        }
        if(depth==N) return;
        
        visited[depth] = true;
        pickDice(depth+1, cnt+1);
        visited[depth] = false;
        pickDice(depth+1, cnt);
    }
    public void calScore(List<Integer> A, List<Integer> B){ 
        List<Integer> Asum = getSumList(A);
        List<Integer> Bsum = getSumList(B);
        Collections.sort(Bsum);
        
        long win = 0;
        long draw = 0;
        for(int a : Asum){
            int less = lowerBound(Bsum, a);
            int equal = upperBound(Bsum, a) - less ;
            win += less;
            draw += equal;
        }
        double winProb = (double) win / (Asum.size() * Bsum.size());
        
        if(winProb > maxWinProb){
            maxWinProb = winProb;
            for(int i=0; i<A.size(); i++){
                bestChoice[i] = A.get(i)+1;
                Arrays.sort(bestChoice);
            }
        } 
    } 
    public List<Integer> getSumList(List<Integer> list){
        List<Integer> sumList = new ArrayList<>();
        dfsDice(list, 0,0, sumList);
        return sumList;
    }
    public void dfsDice(List<Integer> diceIdx, int depth, int sum, List<Integer> list){
        if(depth==diceIdx.size()){
            list.add(sum);
            return;
        }
        int[] die = dice[diceIdx.get(depth)];
        for(int n : die){
            dfsDice(diceIdx, depth+1, sum+n, list);
        }
    }
    public int lowerBound(List<Integer> list, int key) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    
    public int upperBound(List<Integer> list, int key) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
} 

 