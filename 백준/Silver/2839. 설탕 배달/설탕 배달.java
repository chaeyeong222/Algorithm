import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sugar = new int[n+1];
        if(n>=3) sugar[3]=1;
        if(n>=5) sugar[5]=1;
        for (int i = 6; i < n+1; i++) {
            if(i%5==0) sugar[i] = sugar[i-5]+1;
            else if(i%3==0) sugar[i] = sugar[i-3]+1;
            else if(sugar[i-5]!=0 && sugar[i-3]!=0)
                sugar[i] = Math.min(sugar[i-5],sugar[i-3])+1;
        }
        if(sugar[n]==0) System.out.println(-1);
        else System.out.println(sugar[n]); 
    }
}
