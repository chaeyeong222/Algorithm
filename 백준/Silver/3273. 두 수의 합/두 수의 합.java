import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        int start = 0;
        int end = n-1;

        int answer = 0;
        while(start<end){
            if(nums[start]+nums[end] < goal){
                start++;
            }else if( nums[start]+nums[end] > goal){
                end--;
            }else if(nums[start]+nums[end]==goal){
                answer++;
                start++;
                end--;
            }
        }
        System.out.println(answer);


    }
}