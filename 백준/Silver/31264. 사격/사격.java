
import java.io.*;
import java.util.*;
//## 31264 사격
class Main {
    static int N, M, goalScore;
    static int [] num;
    static long ans;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(ans);
    }
    public static void pro(){
        Arrays.sort(num);//오름차순 정렬

        int start = 1;
        int end = num[N-1];

        ans = Long.MAX_VALUE;

        if(num[0] >= goalScore) {
            ans = goalScore;
            return;
        }
        while(start <= end){
            int mid = (start+end)/2;
            boolean temp = check(mid);
            if(temp){
                ans = Math.min(ans, mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
    }
    public static boolean check(int firstpower){

        if(num[0] > firstpower) return false;

        int cnt = 0;
        long sum = 0;
        long power = firstpower;
        int nowIdx = 0;
        while(cnt < M){

            boolean flag = true;
            for (int i = nowIdx; i < N; i++) {
                if(power < num[i]){
                    nowIdx = i-1;
                    flag = false;
                    break;
                }
            }

            if(flag){
                if( num[N-1] <= power){
                    nowIdx = N-1;
                }
            }

            power += num[nowIdx];
            sum += num[nowIdx];
            cnt++;
            if(sum >= goalScore){
                return true;
            }

        }
        return false;
    }


    public static void set() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        goalScore = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
          num[i] = Integer.parseInt(st.nextToken());
        }
    }
}