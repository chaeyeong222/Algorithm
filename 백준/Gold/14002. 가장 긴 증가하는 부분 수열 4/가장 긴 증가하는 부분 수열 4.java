import java.io.*;
import java.util.*;

class Main {
    static int N, maxIdx, maxCnt;
    static int[] num, dp, link; 
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(maxCnt).append('\n');
        int idx = maxIdx;
        Stack<Integer> stack =  new Stack<>();
        while(idx >=0 ){
            stack.push(num[idx]);
            idx = link[idx];
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }
    public static void pro(){
        dp[0] = 1;
        maxIdx = 0;
        maxCnt = 1;
        Arrays.fill(link, -1);
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(num[j]<num[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    link[i] = j;
                    if(dp[i]>maxCnt){
                        maxCnt = dp[i];
                        maxIdx = i;
                    } 
                }
            }
        }  
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        dp = new int[N];
        link = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}
/**
 * 연결된 애들 가지고 있으면 될듯?
 * 가장 큰 애의 idx 를 업데이트하면서 가고
 * 그럼 최대 2번 for문돔
 * */