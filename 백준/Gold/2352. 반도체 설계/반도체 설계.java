import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] port, check;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        port = new int[n];
        check = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            port[i] = Integer.parseInt(st.nextToken());
        }
        check[0] = port[0];
        int LISIdx = 1;
        for (int i = 0; i < n; i++) {
            if(check[LISIdx-1] < port[i] ){
                LISIdx++;
                check[LISIdx-1] = port[i];
            }else{
                check[findIdx(i, LISIdx)] = port[i]; 
            }
        }
 

        System.out.println(LISIdx);

    }//main
    public static int findIdx(int index, int LISIdx){
        int key = index;
        int start = 0;
        int end = LISIdx;
        while (start <  end){
            int mid = (start+end)/2;
            if( check[mid] < port[key] ){
                start = mid+1;
            }else{
                end = mid;
            }
        }//while
        return start;
    }
}