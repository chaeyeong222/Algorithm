import java.io.*;
import java.util.*;
//##차이를 최대로
class Main {
    static int n, max;
    static int answer;
    static int[] num;
    static int[] selected;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        set();
        answer = 0;
        max = Integer.MIN_VALUE;
        recur(0);
        System.out.println(max);

    }
    static void recur(int k){
        if(k==n){
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(selected[i]-selected[i+1]);
            }
            max = Math.max(max, sum);
        }else{
            for (int i = 0; i < n; i++) { //처음부터 확인
                if(visited[i]) {  continue; }
                selected[k] = num[i];
                visited[i] = true;
                recur(k+1);
                visited[i] = false;
            }
        }//else
    }

    static void checkMax(){

    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        selected = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}