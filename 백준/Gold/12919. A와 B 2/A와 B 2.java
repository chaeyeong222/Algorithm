import java.io.*;
import java.util.*;
//##12919
class Main {
    static String goal;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        goal = br.readLine();
        String start = br.readLine();

        answer = 0;
        checkWord(start);
        System.out.println(answer);
    }
    public static void checkWord(String word){

        if(word.equals(goal)) {
            answer = 1;
            return;
        }
        if(word.length()==goal.length()){ //길이가 같아지면 더 추가 불가
            return;
        }
        if(word.endsWith("A")){
            checkWord(word.substring(0, word.length()-1));
        }

        if(word.startsWith("B")){
            checkWord(new StringBuilder(word.substring(1)).reverse().toString());
        }
    }

}