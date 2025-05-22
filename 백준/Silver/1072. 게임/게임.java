import javafx.geometry.Pos;

import java.io.*;
import java.util.*;

class Main {
    static double N,M;
    static int pivot ;
    static long ans;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        if(ans==Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
    public static void pro(){
        long start = 0L;
        long end = 1000000000L;
        while(start<=end){
            long mid = (start+end)/2;
            if(check(mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
    }
    public static boolean check(long num){
        if((int)((M+num)/(N+num)*100)>pivot){
            ans = Math.min(ans, num);
            return true;
        }
        return false;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pivot = (int)(M * 100 / N);
        ans = Long.MAX_VALUE;
    }
}