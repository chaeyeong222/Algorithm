import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int start = 0;
        int end = 0;
        int nowSum = 0;
        while(end<=n){
             if(nowSum>=m){
                 nowSum-=nums[start++];
             }else if(nowSum<m){
                 nowSum+=nums[end++];
             }
             if(nowSum==m){
                 cnt++;
             }
        }
        System.out.println(cnt);

    }

}