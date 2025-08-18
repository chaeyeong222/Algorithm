
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, len;
    static String word;
    static int[] need, now;
    static int answer;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        for (int i = 0; i < M; i++) {
            char temp = word.charAt(i);
            now[findIdx(temp)]++;
        }
        check();
        int start = 0;
        int end = M;
        while(end<word.length()){
            now[findIdx(word.charAt(start++))]--;
            now[findIdx(word.charAt(end++))]++;
            check();
        }
        System.out.println(answer);
    }
    public static void check(){
        for (int i = 0; i < 4; i++) {
            if(now[i]<need[i]) return;
        }
        answer++;
    }
    public static int findIdx(char c){
        if(c=='A'){
            return 0;
        }else if(c=='C'){
            return 1;
        }else if(c=='G'){
            return 2;
        }
        return 3;
    }

    static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        word = br.readLine();
        len = word.length();
        need = new int[4];
        now = new int[4];
        answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }
    }
}