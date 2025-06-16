import java.io.*;
import java.util.*;

class Main {
    static int N;
    static long answer, total;
    static int[] num;
    static long[] toLeftSum, toRightSum;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    public static void pro() {
        case1();
        case2();
        case3();
    }
    public static void case1(){ //벌1 왼쪽 고정,벌통 오른쪽 끝 고정 > 벌2위치선택
        long bee1, bee2;
        for (int i = 1; i < N-1; i++) {
            bee1 = total-num[0]-num[i];
            bee2 = total-toRightSum[i];
            answer = Math.max(answer, bee1+bee2);
        }
    }

    public static void case2(){ //벌롱왼쪽 고정, 벌1 오른쪽 끝 고정 > 벌2위치선택
        long bee1, bee2;
        for (int i = 1; i < N-1; i++) {
            bee1 = total - num[N-1] - num[i];
            bee2 = toRightSum[i]-num[i];
            answer = Math.max(answer, bee1+bee2);
        }
    }
    public static void case3(){ //벌1 왼쪽 고정, 벌2 오른쪽 끝 고정 > 벌통 위치선택
        long bee1, bee2;
        for (int i = 1; i < N-1; i++) {
            bee1 = toRightSum[i]-num[0];
            bee2 = toLeftSum[i] - num[N-1];
            answer = Math.max(answer, bee1+bee2);
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long temp = 0;
        num = new int[N];
        toLeftSum = new long[N];
        toRightSum = new long[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            temp += num[i];
            toRightSum[i] = temp;
        }
        temp = 0;
        for (int i = N-1; i >= 0; i--) {
            temp += num[i];
            toLeftSum[i] = temp;
        }
        total = toRightSum[N-1];
    }
}