

import java.io.*;
import java.util.*;

public class Main {
    static int[] num = {1,5,10,50};
    static int[] arr;
    static int N;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        find(0,  0,0);
        System.out.println(set.size());
    }
    public static void find(int idx, int cnt, int sum){
        if(cnt==N){
            set.add(sum);
            return;
        }
        for (int i = idx; i < 4; i++) {
            find(i, cnt+1, sum+num[i]);
        }
    }
}
