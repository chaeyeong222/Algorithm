import java.io.*;
import java.util.*;

class Main {
    static String target;
    static int[][] map;
    static HashMap<String, Integer> pattern;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        if(isAllWordSame()){ //모두 같은 문자라면
            System.out.println(-1);
        }else{
             if(PALINDROME()) System.out.println(target.length()-1);
             else System.out.println(target.length());
        }
    }
    public static boolean isAllWordSame(){
        char temp = target.charAt(0);
        for (int i = 1; i < target.length(); i++) {
            if(target.charAt(i)!=temp) return false;
        }
        return true;
    }
    public static boolean PALINDROME(){
        for (int i = 0; i < target.length()/2; i++) {
            if(target.charAt(i)!=target.charAt(target.length()-1-i)){
                return false;
            }
        }
        return true;
    }


    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        target = br.readLine();
    }
}
