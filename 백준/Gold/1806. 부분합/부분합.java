import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] nums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        int answer = Integer.MAX_VALUE;


        while(right<=n){
            if(sum>=target){
                sum-=nums[left++];
                cnt--;
            }else if(sum<target){
                sum+=nums[right++];
                cnt++;
            }
            if(sum>=target){
                answer = Math.min(answer, cnt );
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        }else
        System.out.println(answer);

    }

}