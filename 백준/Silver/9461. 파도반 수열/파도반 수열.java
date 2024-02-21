import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Long[] nums = new Long[101];

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int TC = 0; TC < T; TC++) {
            int n = Integer.parseInt(br.readLine());
            nums[0]=0L;
            nums[1]=1L;
            nums[2]=1L;
            nums[3]=1L;

           if(nums[n]==null){
               for (int i = 4; i < 101; i++) {
                   nums[i] = nums[i-2]+nums[i-3];
               }
           }
            sb.append(nums[n]).append('\n');
        }//tc
        System.out.println(sb);
    }

}