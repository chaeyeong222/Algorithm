import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static String word,sentence;
    static int[] wCnt;
    static int[] temp;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        int answer = 0;
        for(char c : word.toCharArray()){
            int t = getIdx(c);
            wCnt[t]++;
        }

        temp = new int[52];
        for (int i = 0; i < N; i++) {
            temp[getIdx(sentence.charAt(i))]++;
        }
        answer+=compare();

        int idx = 1;
        while(idx<=(M-N)){
            temp[getIdx(sentence.charAt(idx-1))]--;
            temp[getIdx(sentence.charAt(idx+N-1))]++;
            answer+= compare();
            idx++;
        }

        System.out.println(answer);

    }
    public static int compare(){
        for (int i = 0; i < 52; i++) {
            if(wCnt[i]!=temp[i]) return 0;
        }
        return 1;
    }
    public static int getIdx(char c){
        if('A'<= c && c<='Z'){
            return c-'A';
        }
        return c-'a'+26;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        word = br.readLine();
        wCnt = new int[52];
        sentence = br.readLine();
    }
}