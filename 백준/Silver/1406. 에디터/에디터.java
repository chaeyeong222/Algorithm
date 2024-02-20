import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < words.length(); i++) {
            left.add(words.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if(temp.length()>1){ //P인경우
                String[] tt = temp.split(" ");
                left.push(tt[1].charAt(0));
            }else if(temp.charAt(0)=='L') {
                //왼쪽걸 빼서 오른쪽에 넣기
                 if(!left.isEmpty()){
                     right.push(left.pop());
                 }
            }else if(temp.charAt(0)=='D') {
                //오른쪽껄 빼서 왼쪽에 넣기
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            }else if(temp.charAt(0)=='B') {
                //왼쪽 문자 삭제하기
                if(!left.isEmpty()){
                    left.pop();
                }
            }
        }// for
        StringBuilder answer = new StringBuilder();
        StringBuilder aa = new StringBuilder();
        while (!left.isEmpty()){
            aa.append(left.pop());
        }
        for (int i = aa.length()-1; i >=0 ; i--) {
            answer.append(aa.charAt(i));
        }

        while(!right.isEmpty()){
            answer.append(right.pop());
        }
        System.out.println(answer);

    }
}