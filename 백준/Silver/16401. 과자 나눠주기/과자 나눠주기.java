import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 1;
        int end = arr[arr.length-1];
        int maxLength = 0;
        int cnt = 0;
        while(start<=end){
            cnt = 0;
            int mid = (start+end)/2;
            for (int i = 0; i < n; i++) {
                cnt += (arr[i]/mid);
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