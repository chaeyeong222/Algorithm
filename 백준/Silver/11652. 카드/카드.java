import org.omg.CORBA.MARSHAL;

import java.io.*;
import java.util.*;
//##11652 카드
class Main {
    static int n;
    static long[] num;
    static long minValue; //정답값
    static long maxCnt; //개수 비교
    public static void main(String[] args) throws Exception {
        set();
        Arrays.sort(num);
        findMaxCnt();
        System.out.println(minValue);

    }
    static void findMaxCnt(){

        int cnt = 1;
        long prevNum = num[0];
        for (int i = 1; i < n; i++) {
            if(prevNum==num[i]){
                cnt++;
            }else{
                //이전까지의 값 갱신해주기
                if(cnt > maxCnt){ //
                    minValue = prevNum;
                    maxCnt = cnt;
                }else if(cnt==maxCnt && minValue > prevNum){ //교체
                    minValue = prevNum;
                }
                cnt = 1;
                prevNum = num[i];
            }
        }
        if (cnt > maxCnt) {
            minValue = prevNum;
        } else if (cnt == maxCnt && minValue > prevNum) {
            minValue = prevNum;
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new long[n];
        maxCnt = 0;
        minValue = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
    }
}