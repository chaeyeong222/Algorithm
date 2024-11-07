
import java.io.*;
import java.util.*;
//##
class Main {
    static String word;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            word = br.readLine();
            int[] value = new int['z'-'a'+1];
            k = Integer.parseInt(br.readLine());

            for (int i = 0; i < word.length(); i++) {
                value[word.charAt(i)-'a']++;
            }

            int maxV = 0;
            int minV = Integer.MAX_VALUE;
            for (int i = 0; i < word.length(); i++) {
                char temp = word.charAt(i);
                if(value[temp-'a']<k) continue;

                String substr = checkWord(temp, i);

                if(substr!=null){
                    if(minV > substr.length()) minV = substr.length();
                    if(maxV < substr.length()) maxV = substr.length();
                }
            }

            if(minV!=Integer.MAX_VALUE) sb.append(minV).append(' ').append(maxV).append('\n');
            else sb.append(-1).append('\n');
        }//TC
        System.out.println(sb);
    }
    public static String checkWord(char target, int start){
        int cnt = 0;
        for(int i=start; i<word.length(); i++){
            if(word.charAt(i)==target) cnt++;
            if(cnt==k) return word.substring(start,i+1);
        }
        return null;
    }
}