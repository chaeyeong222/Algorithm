

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] num;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        System.out.println(quadTree(0,0, N));
    }
    public static String quadTree(int r, int c, int size){
        if(rangeCheck(r,c,size)){
            return num[r][c]+"";
        }else{
            int s = size/2;
            return "("+
            quadTree(r,c,s)+ 
            quadTree(r,c+s,s)+
            quadTree(r+s,c,s)+
            quadTree(r+s,c+s,s)+ ")";
        }
    }
    public static boolean rangeCheck(int r, int c, int size){
        char pivot = num[r][c];
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if(num[i][j]!=pivot) return false;
            }
        }
        return true;
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new char[N][N];
        for (int i = 0; i < N; i++) {
            num[i] = br.readLine().toCharArray();
        }
    }
}