import java.util.*;
import java.io.*;

//
public class Main {
    static List<Integer> minus, plus;
    static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int answer = 0;
        minus = new ArrayList<>();
        plus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num>0) plus.add(num);
            else minus.add(Math.abs(num));
        }
        //정렬하기
        Collections.sort(minus);
        Collections.sort(plus);
        int leftSize = minus.size();
        int rightSize = plus.size();

        if(leftSize==0 && rightSize!=0){
            System.out.println(nothing(plus));
        }else if(rightSize==0 && leftSize!=0){
            System.out.println(nothing(minus));
        } else if(rightSize==0 && leftSize==0){
            System.out.println(0);
        }else{
        //절댓값이 가장 큰 애 구해서 거기부터 들 수 있는 책 개수만큼은 1번만더하기
        //1.비교
        if(minus.get(leftSize-1) > plus.get(rightSize-1) ){
            //더 큰 애는 한번만 더하기
            answer += minus.get(leftSize-1);
            //둘수있는 책의 수만큼 제외
            for (int i = leftSize-1-m; i >= 0; i-=m) {
                if(i<0) break;
                answer+=(minus.get(i)*2);
            }
            for (int i = rightSize-1; i >=0 ; i-=m) {
                answer+=(plus.get(i)*2);
            }
        }else {
            //더 큰 애는 한번만 더하기
            answer += plus.get(rightSize-1);
            //둘수있는 책의 수만큼 제외
            for (int i = rightSize-1-m; i >= 0; i-=m) {
                //들수 있는 수만큼 제외
                if(i<0) break;
                answer+=(plus.get(i)*2);
            }
            for (int i = leftSize-1; i >=0 ; i-=m) {
                answer+=(minus.get(i)*2);
            }
        }
         System.out.println(answer);
        }
    }
    public static int nothing(List<Integer> oneside){
        int cnt = 0;
        int size = oneside.size();

        cnt += oneside.get(size-1);
        //둘수있는 책의 수만큼 제외
        for (int i = size-1-m; i >= 0; i-=m) {
            //들수 있는 수만큼 제외
            if(i<0) break;
            cnt+=(oneside.get(i)*2);
        }

        return cnt;
    }
}
