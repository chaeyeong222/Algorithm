import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long X;
    static long[] pattyCnt, totalLen;
    static long answer;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){
        pattyCnt = new long[N+1];
        totalLen = new long[N+1];
        pattyCnt[0] = 1;
        totalLen[0] = 1;

        for (int i = 1; i <= N; i++) {
            totalLen[i] = totalLen[i-1]*2 + 3; // 양 끝에 번 + 가운데 패티
            pattyCnt[i] = pattyCnt[i-1]*2 +1; // 패티
        }
        System.out.println(solve(N, X));

    }
    public static long solve(int level, long idx){
        if(level==0){
            return 1;
        }
        if(idx==1){
            return 0;
        }else if(idx<= (1 + totalLen[level-1])){
            return solve(level-1, idx-1);
        }else if(idx== (1 + totalLen[level-1]+1)){
            return pattyCnt[level-1]+1;
        }else if(idx<(totalLen[level-1])+1+(totalLen[level-1])){
            return pattyCnt[level-1]+1
                + solve(level-1, idx-(1+totalLen[level-1]+1));
        }else{
            return pattyCnt[level];
        }
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
    }
}