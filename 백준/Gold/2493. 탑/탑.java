import java.io.*;
import java.util.*;
//#2493 탑
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }//입력

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //스택에는 인덱스를 넣는다
        result[0] = 0;
        for (int i = 1; i < n; i++) {
            while(true){
                if(stack.isEmpty()){
                    result[i] = 0;
                    stack.push(i);
                    break;
                }
                if(top[stack.peek()] > top[i]){
                    result[i] = stack.peek()+1;
                    stack.push(i);
                    break;
                }
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);


    }
}