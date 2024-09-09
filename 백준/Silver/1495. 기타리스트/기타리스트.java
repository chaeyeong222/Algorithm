import java.io.*;
import java.util.*;
//1495 기타리스트
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] possible = new boolean[n][max+1];
        possible[0][start] = true;//시작값체크
        //먼저 볼룸 범위 체크해서 가능한지 체크한다
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                if(possible[i-1][j]){
                    if(j-v[i]>=0) possible[i][j-v[i]] = true;
                    if(j+v[i]<=max) possible[i][j+v[i]] = true;
                }
            }
        }

        //max V 체크
        int answer = -1;
        for (int i = 0; i <= max; i++) {
            if(possible[n-1][i]){
                if(i-v[n]>=0){
                    answer=Math.max(answer, i-v[n]);
                }
                if(i+v[n]<=max){
                    answer = Math.max(answer, i+v[n]);
                }
            }
        }
        System.out.println(answer);
    }
}