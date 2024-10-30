import java.util.*;
import java.io.*;

public class Main {
    static int[] move, check;
    static  int n,m;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        move = new  int[101]; //어디로 이동해야하는지 알려주는 배열
        check = new int[101]; // 100까지 가는데 몇번 걸리는지 체크하는 배열
        for (int i = 0; i < 101; i++) {
            move[i] = i;
        }
        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            move[start] = end;
        }
        findMin(1);
        System.out.println(check[100]);
    }
    public static void findMin(int now){
        Queue<Integer> que = new LinkedList<>();
        que.offer(now);
        while(!que.isEmpty()){
            int temp = que.poll();

            for (int i = 1; i <= 6 ; i++) {
                int next = temp + i;
                if(next>100){ //범위벗어나면 끝
                    continue;
                }
                if(check[move[next]]==0){
                    que.offer(move[next]);
                    check[move[next]] = check[temp]+1;
                }
                if(check[next] == 100){
                    return;
                }

            }


        }
    }

}//class