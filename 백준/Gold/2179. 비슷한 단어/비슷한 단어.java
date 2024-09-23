import java.io.*;
import java.util.*;
//##2179
class Main {
    static String answer1, answer2;
    static int cnt ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
        answer1 = "";
        answer2 = "";
        cnt = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n; j++) {
                 check(word[i], word[j]);
            }
        }
        System.out.println(answer1);
        System.out.println(answer2);
    }
    public static void check(String pivot, String word2){

        if(pivot.equals(word2)) return;
        String first = pivot;
        String second = word2;
        if(pivot.length()>word2.length()){
            first = word2;
            second = pivot;
        }
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i)!=second.charAt(i)){
                break;
            }else{
                count++;
            }
        }
        if(count > cnt){
            cnt=count;
            answer1 = pivot;
            answer2 = word2;
        }
    }
}