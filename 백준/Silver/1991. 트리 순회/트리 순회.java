import java.io.*;
import java.util.*;
//##1991 트리 순회
class Main {
    static int N;
    static int[][] tree;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(sb);
    }
    public static void pro(){
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
    }

    public static void preOrder(int value){
        if(value==-1) return;
        sb.append((char)(value+'A'));
        preOrder(tree[value][0]);
        preOrder(tree[value][1]);
    }

    public static void inOrder(int value){
        if(value==-1) return;
        inOrder(tree[value][0]);
        sb.append((char)(value+'A'));
        inOrder(tree[value][1]);
    }

    public static void postOrder(int value){
        if(value==-1) return;
        postOrder(tree[value][0]);
        postOrder(tree[value][1]);
        sb.append((char)(value+'A'));
    }



    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new int[26][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char temp = st.nextToken().charAt(0);
            int value = temp-'A';
            for (int j = 0; j < 2; j++) {
                char temp2 = st.nextToken().charAt(0);
                if(temp2!='.'){
                    tree[value][j] = temp2-'A';
                }else{
                    tree[value][j] = -1;
                }
            }
        }//입력
        sb = new StringBuilder();

    }
}