
import java.io.*;
import java.util.*;
//## 13144
class Main {
    static int N;
    static int[] num;
    static int[] cnt;
    static long answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    static void pro(){
        cnt = new int[100001];
        int right = 0;
        for (int left = 0; left < N; left++) {
            //right 를 최대한 옮겨준다.
            while(right<N && cnt[num[right]]==0){ //오른쪽을 확장 조건 : 범위 안에 있고, 현재 종류가 없어야됨.
                cnt[num[right]]++; // 오른쪽 카운트해주고
                right++; //한칸 이동
            }//while

            cnt[num[left]]--; //왼쪽 제거

            answer += (right-left);
        }

        System.out.println(answer);


    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
    }
}