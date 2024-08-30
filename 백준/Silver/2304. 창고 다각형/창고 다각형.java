
import java.io.*;
import java.util.*;
//##2304 창고다각형
public class Main {
    static int sum, n, maxHIdx;
    static int[][] num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n][2];
        StringTokenizer st;
        int maxHeight = 0;
        maxHIdx = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(num[i][1], maxHeight);
        }
        //가로idx기준 오름차순 정렬
        Arrays.sort(num, new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]-o2[0];
            }
        });

        //가장 높은 기둥과 그 기둥의 위치 체크
        for (int i = 0; i < n; i++) {
            if(maxHeight==num[i][1]){
                maxHIdx = i;
                break;
            }
        }
        sum=0;//합계 
        //높은기둥 기준 왼쪽
        leftSide();
        //높은기둥 기준 오른쪽
        rightSide();
        System.out.println(sum+maxHeight);
    }
    public static void leftSide(){
        Stack<Integer> stack = new Stack<>(); //스택에 들어가는 값은 idx
        stack.push(0);//
        for (int i = 1; i <= maxHIdx; i++) { //2부터 0까지
            if(num[i][1]!=0 && num[stack.peek()][1] <= num[i][1]){ //현재 스택에 있는 애보다 큰 애를 만나면
                sum+=(num[i][0]-num[stack.peek()][0])*num[stack.peek()][1]; //지금까지의 다각형 더해주고
                stack.push(i); //다음애를 넣어준다
            }
        }
    }//leftside

    public static void rightSide(){
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);//가장 처음 idx 넣어줌
        for (int i = n-2; i >= maxHIdx; i--) {
            if(num[i][1]!=0 && num[stack.peek()][1] <= num[i][1]){
                sum+=(num[stack.peek()][0]-num[i][0])*num[stack.peek()][1];
                stack.push(i);
            }
        }
    }//rightside
}