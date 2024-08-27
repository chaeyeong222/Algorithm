import java.io.*;
import java.util.*;
//## 2304 창고다각형
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int x =  Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;//현재합계
        int max = 0; //최대값
        int maxCnt = 0;// 개수
        for (int i = 0; i < x; i++) {
            sum+=num[i];
        } 

        max = sum;
        if(sum!=0) {
            maxCnt = 1;
        }


        //5-2 +1 = 3
        //1234
        for (int i = 0; i < n-x; i++) {
            sum -= num[i];
            sum += num[i+x];
            if(sum==0) continue;
            if(sum > max) {
                max = sum;
                maxCnt = 1;
            }else if(sum==max ){
                maxCnt++;
            }
        }

        if (maxCnt == 0) {
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(maxCnt);
        }


    }
}