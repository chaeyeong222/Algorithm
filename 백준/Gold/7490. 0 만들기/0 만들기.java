import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static List<String> list;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        answer = new StringBuilder();
        list = new ArrayList<>();
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            makeNum(1,  sb);
            answer.append('\n');
        }
        System.out.println(answer);
    }
    public static void makeNum(int idx, StringBuilder sb){
        if(idx>=N) {
            String t = sb.toString();
            if(calNum(t.trim())==0){
                answer.append(sb).append('\n');
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder(sb);
        makeNum(idx+1, sb3.append(' ').append(idx+1));
        StringBuilder sb1 = new StringBuilder(sb);
        makeNum(idx+1, sb1.append('+').append(idx+1));
        StringBuilder sb2 = new StringBuilder(sb);
        makeNum(idx+1, sb2.append('-').append(idx+1));
    }
    public static int calNum(String temp){
        int cur = 0;
        List<Integer> num = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            char tt = temp.charAt(i);
            if(Character.isDigit(tt)){
                cur = cur * 10 +(tt-'0');
            }else if(tt=='+' || tt=='-'){
                ops.add(tt);
                num.add(cur);
                cur = 0;
            }
        }
        num.add(cur);

        int sum = num.get(0);
        for (int i = 0; i < ops.size(); i++) {
            if(ops.get(i)=='+'){
                sum += num.get(i+1);
            }else{
                sum -= num.get(i+1);
            }
        }
        return sum;
    }
}