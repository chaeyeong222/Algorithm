import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long start = 1;
        long end = arr[n-1];
        long maxLength = 0;
        while(start<=end){
            long cnt = 0;
            long mid = (start+end)/2;
            for (int i = 0; i < n; i++) {
                long cut = arr[i]-mid;
                if(cut>0) cnt+=cut;
            }
            if(cnt>=m) {
                start = mid+1;
                maxLength = Math.max(maxLength, mid);
            } else {
                end = mid-1;
            }
        }
        System.out.println(maxLength);

    }
}