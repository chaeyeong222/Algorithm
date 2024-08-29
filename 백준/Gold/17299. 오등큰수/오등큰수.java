
import java.io.*;
import java.util.*;
//##17299 오등큰수
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n+1];
        int[] cnt = new int[1000001];
        int[] result = new int[n+1]; //결과를 담을 배열
        //인덱스를 기준으로 cnt 체크
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            cnt[num[i]]++;
        }
        // 오른쪽부터 왼쪽으로 이동
        // 스택에는  인덱스 값을 넣어준다
        // 스택에 있는 애는 오등큰수가 될 수 있는 후보들
        Stack<Integer> stack = new Stack<>();
        stack.push(n);//마지막 애는 무조건 -1
        result[n] = -1;
        for (int i = n-1; i > 0; i--) {
            while(true){
                if(stack.isEmpty()){ //오등큰수가 될 수 있는 애가 없음
                    result[i] = -1;
                    stack.push(i);
                    break;
                }
                int now = stack.peek();
                if( cnt[num[now]] > cnt[num[i]]){//스택에 있는 애가 더 개수 많다면 체크 = 오등큰수
                    result[i] = num[now];
                    stack.push(i); //오등큰수 될 수 있는 후보들
                    break;
                }
                stack.pop();
            }
        }//
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}