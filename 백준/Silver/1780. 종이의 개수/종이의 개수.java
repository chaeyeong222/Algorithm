import java.io.*;
import java.util.*;

class Main {
    static int n ;
    static int[][] map;
    static HashMap<Integer, Integer> cnt;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        System.out.println(cnt.get(-1));
        System.out.println(cnt.get(0));
        System.out.println(cnt.get(1));
    }
    public static void pro(){
        divide(0,0,n);
    }
    public static void divide(int r, int c, int size) {
         if(rangeCheck(r,c,size)){
             cnt.put(map[r][c], cnt.getOrDefault(map[r][c],0)+1);
             return;
         }
         int newSize = size/3;
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 divide(r+newSize*i, c+newSize*j, newSize);
             }
         }
    }
    public static boolean rangeCheck(int startR, int startC, int size){
        int target = map[startR][startC];
        for (int i = startR; i < startR+size; i++) {
            for (int j = startC; j < startC+size; j++) {
                if(map[i][j]!= target) return false;
            }
        }
        return true;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt.put(-1,0);
        cnt.put(0,0);
        cnt.put(1,0);

    }
}