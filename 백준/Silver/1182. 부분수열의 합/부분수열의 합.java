import java.io.*;
import java.util.*;
//## n-queen
class Main {
    static int n, goal;
    static int answer;
    static int[] num;
    public static void main(String[] args) throws Exception {
        input();
        answer = 0;
        if(goal==0){
            answer--;
        }
        recur(0, 0);
        System.out.println(answer);

    }
    static void recur(int now, int sum){
        if(now==n){
            if( sum==goal) answer++;
            return;
        }else{
            recur(now+1, sum+num[now]);
            recur(now+1, sum);
        }
    }

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}