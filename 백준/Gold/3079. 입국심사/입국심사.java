import java.io.*;
import java.util.*;
//## 입국심사
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);
        long start = 1;
        long end = (num[n-1]*m);

        long result = Long.MAX_VALUE;
        long mid=0;
        while(start<=end){
            mid = (start+end)/2;
            long cnt = 0;
            for (long temp : num){
                if(cnt>=m) {break;}
                cnt += (mid/temp);

            }

            if(cnt>=m){
                end = mid -1;
                result = Math.min(result, mid);
            }else{
                start = mid+1;
            }
        }
        System.out.println(result);


    }
}