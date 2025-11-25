import java.io.*;
import java.util.*;
//## 2473
class Main {
    static int N;
    static long[] num;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    static void pro(){
        Arrays.sort(num);
        long best = Long.MAX_VALUE;
        long ans1=0, ans2= 0, ans3 = 0;
        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N-1;

            while (left<right){
                long sum = num[i] + num[left]+ num[right];

                if(Math.abs(sum) < best){
                    best = Math.abs(sum);
                    ans1 = num[i];
                    ans2 = num[left];
                    ans3 = num[right];
                }
                if(sum<0) left++;
                else right--;
            }
        }
        System.out.println(ans1+" "+ans2+" "+ans3);


    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

    }
}