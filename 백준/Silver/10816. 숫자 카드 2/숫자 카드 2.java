import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(0,N-1,num)==0){
                sb.append(0).append(' ');
            }else{
                sb.append(map.get(num)).append(' ');
            }
        }
        System.out.println(sb);
    }
    public static int binarySearch(int start, int end, int key){
        int cnt = 0; 

        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(key==arr[mid]){
                return 1;
            }else if(key<arr[mid]){
                end = mid-1;
            }else if(key>arr[mid]){
                start = mid+1;
            }
        }

        return cnt;

    }
}
