import java.util.*;
class Solution {
    int turn = 0;
    List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[turn][2];
        for(int i=0; i<turn; i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    public void hanoi(int n, int from, int to, int via){
        if(n==1){
            turn++;
            list.add(new int[]{from,to});//가장 큰 원반 옮기기
            return;
        }
        hanoi(n-1, from, via, to); //n-1을 via 로 옮기기
        turn++;
        list.add(new int[]{from,to}); //
        hanoi(n-1, via, to, from); // via에 있는 것들을 to 로 옮기기
    }
}