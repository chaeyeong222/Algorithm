import java.io.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.*;
//##6603 로또
class Main {
    static int n;
    static int[] num;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0){ break;}
            num = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num); //정렬
            recur(0,0);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void recur(int k, int start){ //
        if(k==6){
            for (int i = 0; i < n; i++) {
                if(visited[i]) {sb.append(num[i]).append(' ');}
            }
            sb.append('\n');
        }else{
            for (int i = start; i < n; i++) {
                visited[i] = true;
                recur(k+1, i+1);
                visited[i] = false;
            }
        }
    }
}