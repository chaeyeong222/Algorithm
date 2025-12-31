import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] words;
    static HashSet<Character> set;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){

        StringBuilder sb = new StringBuilder();
        for(String s : words) {
            int idx = findShortcutIndex(s);
            if(idx==-1){ //앞글자만으로 체크가능
                sb.append(s);
            }else { //하나씩 진행
                set.add(Character.toLowerCase(s.charAt(idx)));
                for (int i = 0; i < s.length(); i++) {
                    if(i==idx){
                        sb.append('[').append(s.charAt(i)).append(']');
                    }else{
                        sb.append(s.charAt(i));
                    }
                }
            }sb.append('\n');
        }
        System.out.println(sb);
    }
    public static int findShortcutIndex(String pivot){
        //각 단어의 첫글짜
        int i = 0;
        boolean flag = true;
        for (int j = 0; j < pivot.length(); j++) {
            char c = pivot.charAt(j);
            if(flag && c !=' '){
                if(!set.contains(Character.toLowerCase(c))){
                    return j;
                }
                flag = false;
            }
            if( c==' ') flag = true;
        }

        for (int j = 0; j < pivot.length(); j++) {
            char c = pivot.charAt(j);
            if( c!=' ' && !set.contains(Character.toLowerCase(c))){
                return j;
            }
        }

        return -1;
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        set = new HashSet<>();
    }
}