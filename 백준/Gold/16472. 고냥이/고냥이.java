
import java.io.*;
import java.util.*;
//## 16472
class Main {
    static int N, length;
    static int[] alpha;
    static char[] cat;
    static int ans;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    static void pro(){
        int left = 0;
        int cnt = 0;
        for (int right = 0; right < length; right++) {
            alpha[cat[right]-'a']++;
            if(alpha[cat[right]-'a']==1) {
                cnt++;
            }

            while(cnt>N){
                alpha[cat[left] -'a']--;
                if(alpha[cat[left] -'a' ] == 0) cnt--;
                left++;
            }

            ans = Math.max(ans, right-left+1);

        }
        System.out.println(ans);

    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String temp = br.readLine().trim();
        alpha = new int[27];
        cat  = temp.toCharArray();
        length = temp.length();
        ans = 0;
    }
}