import java.io.*;
import java.util.*;

public class Main {
    static String pivot;
    static int zero, one;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int remainOne = one;
        int remainZero = zero;

        int needZero = zero/2;
        int needOne = one/2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pivot.length(); i++) {
            char c = pivot.charAt(i);

            if(c=='0'){
                if(needZero>0){
                    sb.append('0');
                    needZero--;
                }
                remainZero--;
            }else {
                if(needOne>0 && remainOne-1 < needOne){
                    sb.append('1');
                    needOne--;

                }
                remainOne--;
            }
        }
        System.out.println(sb);
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pivot = br.readLine();
        for (int i = 0; i < pivot.length(); i++) {
            if(pivot.charAt(i)=='0') zero++;
            else one++;
        }
    }
}