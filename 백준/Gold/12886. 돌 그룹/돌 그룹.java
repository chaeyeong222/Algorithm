import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int A,B,C, sum;
    static boolean[][] stone;
    static boolean flag ;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        if(sum%3!=0){
            System.out.println(0); 
        }else{
            dfs(A,B,C);
            System.out.println(flag ? 1 : 0);
        }
    }
    public static void dfs(int a, int b, int c){
        int[] temp = new int[3];
        temp[0]=a;
        temp[1]=b;
        temp[2]=c;
        Arrays.sort(temp);
        a = temp[0];
        b = temp[1];
        c = temp[2]; 

        if(stone[a][b]) return;//이미체크한 것
        stone[a][b] = true;

        if(a==b && b==c) {
            flag = true;
            return;
        }
        dfs(a+a, b-a, c);
        dfs(a, b+b, c-b);
        dfs(a+a, b, c-a);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        stone = new boolean[1001][1001];
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sum = A+B+C;
    }
}