import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static int[] check;

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        check = new int[n]; //LIS 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int lastIdxLIS = 1;
        check[0] = nums[0];
        for (int i = 0; i < n; i++) {
            if(nums[i] > check[lastIdxLIS-1]){
                lastIdxLIS++;
                check[lastIdxLIS-1] = nums[i];
            }else{
                //자리를 바꿀 위치 찾기
               check[LIS(i, lastIdxLIS)] = nums[i];
            }
        }
//        for (int i = 0; i < lastIdxLIS; i++) {
//            System.out.println(i+" " +check[i]);
//        }
        System.out.println(lastIdxLIS);

    }//main
    public static int LIS(int index, int lastIdxLIS){
        int key = index;//기준값idx

        int start = 0;
        int end = lastIdxLIS;
        while(start<end){
            int mid = (start+end)/2;

            //비교값이 기준값보다 작으면
            if(check[mid] < nums[key]){
                start = mid+1;
            }else{
                end = mid;
            }
        }//while
        return start;
    }
}