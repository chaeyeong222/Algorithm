

import java.io.*;
import java.util.*;
//##문자열폭발
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받은값을 하나씩 스택에 넣으면서
        String word = br.readLine();
        String regex = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
            if(stack.size() >= regex.length()){ //폭발문자열보다 커지면 비교
                boolean fire = true;
                for (int j = 0; j < regex.length(); j++) {
                    if(stack.get(stack.size()-regex.length()+j)!=regex.charAt(j)){
                        fire = false;
                        break;
                    }
                }
                if(fire){
                    for (int j = 0; j < regex.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }//
        StringBuilder sb = new StringBuilder();
        String answer = "";
        if(stack.size()==0){
            answer = "FRULA";
        }else{
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            answer = sb.reverse().toString();
        }
        System.out.println(answer);

    }

}