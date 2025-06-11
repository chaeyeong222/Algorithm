import java.io.*;
import java.util.*;

public class Main{
    public static int N, answer;
    public static HashMap<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        N = word.length();
        map = new HashMap<>();
        for(char c : word.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        backTrace(0, ' ');
        System.out.println(answer);

    }
    public static void backTrace(int depth, char prev){
        if(depth==N) {
            answer++;
            return;
        }
        for(char next : map.keySet()){
            int cnt = map.get(next);
            if(cnt==0) continue;
            if(next==prev) continue;
            map.put(next, cnt-1);
            backTrace(depth+1, next);
            map.put(next, cnt);
        }
    }
}
