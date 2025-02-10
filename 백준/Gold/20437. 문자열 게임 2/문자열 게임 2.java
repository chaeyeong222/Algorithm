import java.io.*;
import java.util.*;

public class Main  {
    static char[] check;
    static int K;
    static String sentence;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {
            sentence = br.readLine();
            check = sentence.toCharArray();
            K = Integer.parseInt(br.readLine());

            int minV = Integer.MAX_VALUE;
            int maxV = -1;
            int[] value = new int['z'-'a'+1];
            for (int i = 0; i < check.length ; i++) {
                value[check[i]-'a']++;
            }

            for (int i = 0; i < check.length; i++) {
                char now = check[i];
                if(value[now-'a'] < K) continue;
                String temp = checkLen(now, i);

                if(temp!=null){
                    if(minV > temp.length()) minV =  temp.length();
                    if(maxV < temp.length()) maxV =  temp.length();
                }
                
            }
            if(minV==Integer.MAX_VALUE) sb.append(-1);
            else  sb.append(minV).append(' ').append(maxV);
            
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static String checkLen(char pivot, int start){

        int cnt = 0;
        for (int i = start; i < check.length; i++) {
            if(check[i]==pivot) cnt++;
            if(cnt==K) return sentence.substring(start, i+1);
        }

        return null;
    }
}