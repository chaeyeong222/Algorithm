import java.io.*;
import java.util.*;
//##스타트와 링크
class Main {
    static int n;
    static int[][] power;
    static boolean[] pick;
    static int min;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        set();
        min = Integer.MAX_VALUE;
        recur(0, 0);
        System.out.println(min);

    }
    static void recur(int depth, int cnt){ //현재 확인한 사람 수 , 기준 팀이 선택된 사람 수
        if(depth==n){
            if(cnt==n/2) {checkMin();}
        }else{
            pick[depth] = true; //선택한 경우
            recur(depth+1, cnt+1);
            pick[depth] = false; //선택 안한 경우
            recur(depth+1, cnt);
        }
    }
    static void checkMin(){
        int teamA = 0;
        int teamB = 0;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(pick[i]){
                listA.add(i);
            }else{
                listB.add(i);
            }
        }
        //시너지 계산
        for (int i = 0; i < listA.size()-1; i++) {
            for (int j = i+1; j < listA.size(); j++) {
                teamA += power[listA.get(i)][listA.get(j)];
                teamA += power[listA.get(j)][listA.get(i)];

                teamB += power[listB.get(i)][listB.get(j)];
                teamB += power[listB.get(j)][listB.get(i)];
            }
        }

        int synergy = Math.abs(teamA-teamB);
        min = Math.min(min, synergy);
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        power = new int[n][n];
        pick = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}