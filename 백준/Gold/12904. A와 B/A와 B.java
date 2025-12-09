 import java.io.*;
import java.util.*;
public class Main { 
    static String pivot, goal; 
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        StringBuilder temp = new StringBuilder(goal);
        while(temp.length()!=pivot.length()){
            if(temp.charAt(temp.length()-1)=='A'){
                temp.deleteCharAt(temp.length()-1);
            }else {
                temp.deleteCharAt(temp.length()-1);
                temp.reverse();
            }
        }
        if(temp.toString().equals(pivot)){
            System.out.println(1);
        }else System.out.println(0);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pivot = br.readLine();
        goal = br.readLine();  
    }
}