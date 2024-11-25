import java.io.*;
import java.util.*;
//## 17266 어두운 굴다리
class Main {
    static int n,m;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = n;
        int answer = 0;

        while(start<=end){
            int mid  = (start + end)/2;
            if(check(mid)){
                answer = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(answer);

    }
    public static boolean check(int mid){
        int before = 0;
        for (int i = 0; i < m; i++) {
            if(num[i]-mid <= before) {
                before = num[i]+mid;
            }
            else{
                return false;
            }
        }
        return n-before<=0;
    }
}