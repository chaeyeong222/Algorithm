import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static int[][] map;
    static HashMap<String, Integer> pattern;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {

        int maxCnt = 0;
        for(String key : pattern.keySet()){
            int zerocnt =0;
            for (int i = 0; i < key.length(); i++) {
                if(key.charAt(i)=='0'){
                    zerocnt++;
                }
            }

            if(zerocnt<=k && (k-zerocnt)%2==0 ){
                maxCnt = Math.max(maxCnt, pattern.get(key));
            }
        }
        System.out.println(maxCnt);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        pattern = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            pattern.put(line, pattern.getOrDefault(line, 0)+1);
        }
        k = Integer.parseInt(br.readLine());
    }
}
