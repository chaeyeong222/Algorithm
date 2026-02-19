import java.io.*;
import java.util.*;

class Main {
    public static long[] L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        L = new long[50];
        L[0] = 3;
        int k = 0;
        while(L[k]<N){
            k++;
            L[k] = 2*L[k-1] + (k+3);
        }
        String answer = "";
        while(k>0){
            if(N<=L[k-1]){
                k = k-1;
            }else if(N==L[k-1]+1){
                answer = "m";
                break;
            }else if(N<=L[k-1]+(k+3)){
                answer = "o";
                break;
            }else{
                N = N-(L[k-1]+(k+3));
                k -=1;
            }
        }
        if(k==0){ 
            if(N==1) answer = "m";
            else answer = "o";
        }

        System.out.println(answer);


    }

}
/**
 L[k] = L(k-1) + (k+3) + L(k-1);
      = 2*L(k-1) + (k+3)
 * */