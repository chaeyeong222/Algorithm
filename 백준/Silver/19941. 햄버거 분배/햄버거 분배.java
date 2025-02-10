import java.io.*;
import java.util.*;
class Main {
    static int N, K, cnt;
    static String line;

    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(cnt);
    }
    public static void pro() {
        char[] check = line.toCharArray();
        boolean[] visited = new boolean[check.length];
        for (int i = 0; i < check.length; i++) {
            if(check[i]=='P'){
                for (int j = i-K; j <= i+K; j++) {
                    if(j>=0 && j<N && check[j]=='H' && !visited[j]){
                        cnt++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }


    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = br.readLine();
        cnt = 0;
    }
}