import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer [] dp;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] size = new int[n];
        int[][] wine = new int[n][3];
        for (int i = 0; i < n; i++) {
            size[i] = Integer.parseInt(br.readLine());
        }
        wine[0][0]=0;
        wine[0][1]=size[0];
        wine[0][2]=size[0];
        for (int i = 1; i < n; i++) {
            wine[i][0] = Math.max( Math.max(wine[i-1][0], wine[i-1][1]), wine[i-1][2]);
            wine[i][1] = wine[i-1][0]+size[i];
            wine[i][2] = wine[i-1][1]+size[i];
        }
        System.out.println(Math.max( Math.max(wine[n-1][0], wine[n-1][1]), wine[n-1][2]));
    } 
}
