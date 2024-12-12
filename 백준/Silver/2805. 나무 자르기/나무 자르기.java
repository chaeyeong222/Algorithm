import java.io.*;
import java.util.*;
//##차이를 최대로
class Main {
    static int n, m, ans;
    static int[] tree;
    public static void main(String[] args) throws Exception {
        input();
        pro();

    }
    static void pro(){
        //start 와 end 범위 안에 정답이 존재한다.

        long start = 0;
        long end = 2000000000;
        long ans = 0;

        while(start<=end){
            long mid = (start+end)/2;
            if(determination((int) mid)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(ans);


    }

    static boolean determination(int h){
        //h높이로 나무를 잘랐을때, m만큼을 얻을 수 있으면 true, 아니면 false return
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if(tree[i]>h) sum += (tree[i]-h);
        }
        return sum >= m;

    }

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
    }
}