
import java.io.*;
import java.util.*;
//##22866 탑보기
public class Main {
    static int n;
    static int[] num;
    static int[] dpBigRight;
    static int[] dpBigLeft;

    static int[] resultBigRight;
    static int[] resultBigLeft;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dpBigRight = new int[n+1]; //우큰수
        resultBigRight = new int[n+1]; //우큰수 idx
        leftToRight();

        resultBigLeft = new int[n+1]; //좌큰수 idx
        dpBigLeft = new int[n+1]; //좌큰수
        rightToLeft();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int total = dpBigLeft[i]+dpBigRight[i];
            if(total==0 || (resultBigRight[i]==0 && resultBigLeft[i]==0) )sb.append(0);
            else if(resultBigLeft[i]==0) {
                sb.append(total).append(" ").append(resultBigRight[i]);
            }else if(resultBigRight[i]==0) {
                sb.append(total).append(" ").append(resultBigLeft[i]);
            } else {
                sb.append(total).append(" ");
                if((i-resultBigLeft[i])<=(resultBigRight[i]-i)) sb.append(resultBigLeft[i]);
                else sb.append(resultBigRight[i]);
            }sb.append('\n');
        }
        System.out.println(sb);

    }

    //우큰수
    public static void leftToRight(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        Arrays.fill(resultBigRight,0);
        for (int i = 2; i <= n; i++) {
            while(!stack.isEmpty() && num[i] > num[stack.peek()] ){
                resultBigRight[stack.pop()] = i;
            }
            stack.push(i);
        }

        //누적 구하기
        for (int i = n; i > 0 ; i--) {
            if(resultBigRight[i]==0) dpBigRight[i] =0;
            else dpBigRight[i] = dpBigRight[resultBigRight[i]]+1;
        }
    }

    //좌큰수
    public static void rightToLeft(){
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        Arrays.fill(resultBigLeft,0);
        for (int i = n-1; i > 0; i--) {
            while(!stack.isEmpty() && num[i] > num[stack.peek()] ){
                resultBigLeft[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 1; i <= n; i++) {
            if(resultBigLeft[i]==0)  dpBigLeft[i]=0;
            else dpBigLeft[i] = dpBigLeft[resultBigLeft[i]]+1;
        }
    }
}