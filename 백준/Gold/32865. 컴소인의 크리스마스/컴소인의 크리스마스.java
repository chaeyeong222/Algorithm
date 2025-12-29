import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static Queue<Integer> right;
    static Queue<Integer> wrong;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        if(!addCorrect()) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N-1; i++) {
            if(!addWrong()) {
                System.out.println(-1);
                return;
            }
            if(!addCorrect()) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sb);

    }
    public static boolean addWrong(){
        if(wrong.isEmpty()) return false;
        int idx = wrong.poll();
        num[idx]--;
        sb.append(idx).append('\n');
        if(num[idx]==0) right.add(idx);
        else wrong.add(idx);
        return true;
    }
    public static boolean addCorrect(){
        if(right.isEmpty()) return false;
        sb.append(right.poll()).append('\n');
        return true;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        right = new LinkedList<>();
        wrong = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if(num[i]==0) {
                right.add(i);
            }else{
                wrong.add(i);
            }
        }
    }
}