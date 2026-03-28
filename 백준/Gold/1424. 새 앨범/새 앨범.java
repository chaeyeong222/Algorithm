import java.io.*;
import java.util.*;

class Main {
    static int N, L, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        int n = (C+1)/(L+1);
        if(n % 13 == 0) n--;
        int cnt = N/n;
        if(N%n != 0) {// 딱 나눠 떨어지지 않을때
            cnt++;
            int remain = N%n;
            if(remain%13 ==0){ //만약에 remain이 13의 배수이면
                if(remain + 1 < n && cnt != 1){} // 1개 빌려올 수 있는 경우
                else{
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    } 
}