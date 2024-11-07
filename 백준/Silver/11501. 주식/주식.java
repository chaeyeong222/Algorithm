
import java.io.*;
import java.util.*;
//## 11501
//1.우큰수를 찾는다.
//2.한번더 돌면서  > 오른쪽에 있는 가장 큰 수의 idx 를 찾는다
//3.최우큰수idx - 현재idx = 의 합을 구한다.
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] num = new int[n];
            int[] bigRight = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(n-1);
            bigRight[n-1] = 0;
            for (int i = n-2; i >= 0; i--) {
                while(true){
                    if(stack.isEmpty()){
                        bigRight[i] = 0;
                        stack.push(i);
                        break;
                    }
                    if(num[stack.peek()]>num[i]){
                        bigRight[i] = stack.peek();
                        stack.push(i);
                        break;
                    }
                    stack.pop();
                }
            }
            for (int i = n-1; i >= 0; i--) {
                int bigIdx = bigRight[i]; //우큰수 인덱스
                //만약 그 수가 0이라면 그 수보다 더 큰수는 없는 거임
                // 0 이면 따라하면 안됨. 그냥 가지고 있는거 가져가
                if(bigIdx==0) continue;
                if(bigRight[bigIdx]==0) {
                    dp[i] = bigRight[i];
                }else{
                    dp[i] = dp[bigIdx];
                }
            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(num[dp[i]]==0 || dp[i]==0) continue;
                sum += (num[dp[i]]-num[i]);
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}