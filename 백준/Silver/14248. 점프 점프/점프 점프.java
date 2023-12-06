import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, start;
    static boolean ch[];
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        list = new ArrayList<>();
        list.add(0); //허수
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }
        start = scan.nextInt();
        ch = new boolean[n+1];
        jump(start);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(ch[i]) cnt++;
        }
        System.out.println(cnt);
    }
    static void jump(int now){
        if(now<=0 || now>n ||  ch[now] ){ //탈출조건
            return;
        }
        ch[now] = true;
        jump(now+list.get(now));
        jump(now-list.get(now));
    }
}
