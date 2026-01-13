import java.io.*;
import java.util.*;

public class Main {
    static int n,a,b;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){ 
        if(a+b-1>n) {
            System.out.println(-1);
            return;
        }
        int H = Math.max(a,b); 
        int left = n-(a+b-1);
        
        StringBuilder sb = new StringBuilder();
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < a; i++) {
            list.add(i);
        }
        list.add(H);
        for (int i = b; i > 0; i--) {
            list.add(i);
        }

        if(a>1){
            for (int i = 0; i < left; i++) { sb.append(1).append(' '); }
            for (int i = 1; i < a; i++) { sb.append(i).append(' '); }
            sb.append(H).append(' ');
            for (int i = b-1; i>0; i--) { sb.append(i).append(' '); }
        }else if (a==1){
            sb.append(H).append(' ');
            for (int i = 0; i < left; i++) { sb.append(1).append(' '); }
            for (int i = b-1; i>0; i--) { sb.append(i).append(' '); }
        } 

        System.out.println(sb);



    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }
}