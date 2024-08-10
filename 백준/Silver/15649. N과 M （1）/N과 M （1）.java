import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static boolean[] check;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        check = new boolean[n+1];

        makeArr(0);
        System.out.println(sb);
    }
    public static void makeArr(int depth){
        //탈출조건
        if(depth==m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        //아닐 시
        for (int i = 1; i <= n; i++) {
            if(!check[i]){
                check[i] = true;
                arr[depth] = i;
                makeArr(depth+1);
                check[i] = false;
            }
        }
    }

}