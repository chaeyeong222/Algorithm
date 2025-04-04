import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int k = minus;
        String num = br.readLine();
        //String > char > int 로 비교
        //1. 뺄 수 있는 수가 남아있다면
        // 1.1. 현재값 < 다음값  현재값 빼고 다음값 담아줌
        // 1.2. 현재값 >  다음값  다음값 안담고 패스
        //2. 뺄 수 있는 수 없음
        //그냥 다 담아준다.
        Stack<Integer> stack = new Stack<>();
        stack.push(num.charAt(0)-'0');
        for (int i = 1; i < n; i++) {
            while(true){
                int next = num.charAt(i)-'0';
                if(stack.isEmpty() || k==0) {
                    stack.push(next);
                    break;
                }
                if(stack.peek() >= next){
                    stack.push(next);
                    break;
                }
                if(k-->0) {
                    stack.pop();
                }
            }//while
        }
        //for문돌면서 k개를 다 지우지 못한 경우
        while(stack.size() > (n-minus)){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }

}