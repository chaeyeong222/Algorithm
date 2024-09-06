import java.io.*;
import java.util.*;
//#2579 계단오르기
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 계단 개수
        int[] step = new int[n+1];
        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }//입력
        int[] result = new int[n+1];
        result[1] = step[1];
        if(n>=2){
            result[2] = step[1]+step[2];
        }

        for (int i = 3; i <= n; i++) {
            result[i] = Math.max(result[i-2], step[i-1]+result[i-3])+step[i];
        }


        System.out.println(result[n]);


    }
}