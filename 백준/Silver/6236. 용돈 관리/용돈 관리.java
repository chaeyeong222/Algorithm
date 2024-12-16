import java.io.*;
import java.util.*;
//##용돈 관리
class Main {
    static int N , M;
    static int[] needs;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    static void pro(){
        int start = 1;
        int end =  10000 * 100000;
        while(start<=end){
            int mid = (start+end)/2;
            if(possible(mid)){ //적으면 가능, 인출금액을 줄여보자
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
    }

    static boolean possible(int budget){
        int cnt = 1;
        int money = budget;
        for (int i = 0; i < N; i++) {
            if(needs[i] > budget) return false;
            if(money-needs[i]<0){//돈부족
                cnt++;
                money = budget;
            }
            money -= needs[i];
        }
        return cnt <= M;
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        needs = new int[N];
        for (int i = 0; i < N; i++) {
            needs[i] = Integer.parseInt(br.readLine());
        }
    }
}