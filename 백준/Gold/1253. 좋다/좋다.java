
import java.io.*;
import java.util.*;
//## 13144
class Main {
    static int N;
    static int[] num;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    static void pro(){
        Arrays.sort(num);

        for (int now = 0; now < N; now++) {
            int left = 0;
            int right = N-1;
            while(true) {
                if (left == now) left++;
                else if (right == now) right--;

                if(left>=right) break;

                if (num[left] + num[right] < num[now]) {
                    left++;
                } else if (num[left] + num[right] > num[now]) { 
                    right--;
                } else {
                    answer++;
                    break;
                }
            }
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