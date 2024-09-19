import java.io.*;
import java.util.*;
//##17179 케이크 자르기
class Main {
    public static int[] length;
    public static int n, m , l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        length = new int[m+1];
        for (int i = 0; i < m; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }
        length[m] = l;

        for (int i = 0; i < n; i++) {
            int answer = 0;
            int times = Integer.parseInt(br.readLine());
            int start = 0;
            int end = l;
            while(start<=end){
                int mid = (start+end)/2;
                if(checkSize(mid, times)){
                    start = mid+1;
                    answer = Math.max(mid, answer);
                }else{
                    end = mid -1;
                }
            }
            System.out.println(answer);
        }
        
    }
    public static boolean checkSize(int mid, int times){
        int prev = 0 ;
        for (int i = 0; i <= m; i++) {
            if(length[i]-prev>=mid){
                times--;
                prev = length[i];
            }
        }
        return times < 0 ? true : false;

    }
}