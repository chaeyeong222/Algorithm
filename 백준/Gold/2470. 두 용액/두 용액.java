import javax.swing.plaf.ProgressBarUI;
import java.io.*;
import java.util.*;
//##두 용액
class Main {
    static int n;
    static int[] num;
    static int best_sum;
    static int ansLeft, ansRight;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    static void pro(){
        Arrays.sort(num);
        int left = 0;
        int right = n-1;
        while(left<right){
            if(Math.abs(num[left]+num[right])< best_sum){
                best_sum = Math.abs(num[left]+num[right]);
                ansLeft = num[left];
                ansRight = num[right];
            }
            if(num[left]+num[right] < 0){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(ansLeft+" "+ansRight);
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        best_sum = Integer.MAX_VALUE;
    }
}