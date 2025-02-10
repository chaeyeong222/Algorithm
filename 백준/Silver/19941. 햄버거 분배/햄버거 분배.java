
import java.io.*;
import java.util.*;
//##19941 햄버거분배
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String temp = br.readLine();
        char[] arr = temp.toCharArray();

        boolean[] visited = new boolean[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]=='P'){
                for (int j = i-k; j <= i+k; j++) {
                    if(j<0 || j>=n) continue;
                    if(arr[j]=='H' && !visited[j]) {
                        cnt++;
                        visited[j] = true;
                        break;
                    }
                }//
            }
        }
        System.out.println(cnt);





    }//main
}