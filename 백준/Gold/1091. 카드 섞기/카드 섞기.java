import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] card, rule;
    static HashSet<String> hset = new HashSet<>();
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        //순서가 맞는지 체크
        int cnt = 0;
        StringBuilder sb;
        boolean flag = false;
        while(true){
            //순서체크
            if(seatCheck()){
                flag = true;
                break;
            }

            //이미 가지고 있던 조합인지 체크
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(card[i]);
            }
            if(hset.contains(sb.toString())){ //이미 가지고 있는 조합이면 끝
                break;
            }

            hset.add(sb.toString());
            cnt++;
            mixCard(); //카드섞기
        }

        if(flag) System.out.println(cnt);
        else System.out.println(-1);

    }
    public static void mixCard(){
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            int idx = rule[i];
            temp[idx] = card[i];
        }
        card = temp;

    }
    public static boolean seatCheck(){
        for (int i = 0; i < N; i++) {
            if(card[i] != (i%3)) return false;
        }
        return true;
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        rule = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rule[i] = Integer.parseInt(st.nextToken());
        }
    }
}