import java.io.*;
import java.util.*;

class Main {
    public static long[] len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long M = Long.parseLong(br.readLine());
        len = new long[45];
        len[1] = 5;
        len[2] = 13;
        int k = 2;
        while(len[k]<M &&k<44){
            k++;
            len[k] = len[k-1]+1+len[k-2];
        }

        while(k>2){
            if(M<=len[k-1]){
                k--;
            }else if(M==len[k-1]+1){
                System.out.println("Messi Messi Gimossi");
                return;
            }else{
                M = M-(len[k-1]+1);
                k=k-2;
            }
        }
        if(k==1){
            System.out.println("Messi".charAt((int)(M-1)));
        }else if(k==2){
            if("Messi Gimossi".charAt((int)(M-1))==' '){
                System.out.println("Messi Messi Gimossi");
                return;
            }
            System.out.println("Messi Gimossi".charAt((int)(M-1)));
        }
    }
}