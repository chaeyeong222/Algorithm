import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N,M;
    static String[] c;
    static String[] arr; 
    static boolean[] used;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception {
         set();
         pro();
    } 
    public static void pro(){
        Arrays.sort(c);
        combi(0, 0);
        System.out.println(answer);
    }
    public static void combi(int depth, int start){
        if(depth==N){
            StringBuilder sb = new StringBuilder();
            int vowel = 0;
            int cons = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u") ) vowel++;
                else cons++;
                sb.append(arr[i]);
            }
            if(vowel>0 && cons>1){
                answer.append(sb).append('\n');
            }
            return;
        }
        for (int i = start; i < M; i++) {
            if(!used[i]) {
                arr[depth] = c[i];
                used[i] = true;
                combi(depth+1, i+1);
                used[i] = false;
            }
        }
    }

    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        c  = new String[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            c[i] = st.nextToken();
        }
        arr = new String[N];
        used = new boolean[M];
    }
}
