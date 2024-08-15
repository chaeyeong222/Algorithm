import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        //스택에는 idx 넣어줌
        //큰 수를 만나면 해당값과 stack.peek() 한 값의 인덱스 차 -1 을 결과에 더해준다
        //for 문을 다 돈 후에도 stack 에 값이 있다면, 큰수를 못만난 값, n-idx-1 한 값들을 다 더해주면된다
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && num[stack.peek()] <= num[i]){
                result += (i-stack.pop()-1);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            result += (n-stack.pop()-1);
        }

        System.out.println(result);

    }

}