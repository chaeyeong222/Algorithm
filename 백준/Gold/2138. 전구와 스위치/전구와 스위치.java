import java.io.*;
import java.util.*; 

//##
class Main {
    static int n;
    static int INF = Integer.MAX_VALUE-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] before = br.readLine().split("");
        String[] after = br.readLine().split("");
        int[] light = new int[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            light[i] = Integer.parseInt(before[i]);
            answer[i] = Integer.parseInt(after[i]);
        }
        int[] light2 = light.clone();

        if (isSame(light, answer)) {
            System.out.println(0);
        }else {
            //첫번째 스위치를 안눌럿을때
            int check1 = pushSwitch(light, answer);

            //첫번째 스위치 누르고 시작
            light2[0] = 1 - light2[0];
            light2[1] = 1 - light2[1];

            int check2 = pushSwitch(light2, answer);

            if (check1 == INF && check2 == INF) {
                System.out.println(-1);
            } else {
                System.out.println(Math.min(check1, check2 + 1));
            }
        }

    }
    public static int pushSwitch(int[] arr, int[] check){
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i-1]!=check[i-1]){
                arr[i-1] = 1-arr[i-1];
                arr[i] = 1-arr[i];
                if(i != n-1){
                    arr[i+1] = 1-arr[i+1];
                }
                cnt++;
            }
        }
        if(isSame(arr, check)) return cnt;
        return INF;
    }

    public static boolean isSame(int[] arr, int[] check){
        for (int i = 0; i < n; i++) {
            if(arr[i]!=check[i]) return false;
        }
        return true;
    }
}