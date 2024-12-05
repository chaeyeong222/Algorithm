import java.io.*;
import java.util.*;
//## n-queen
class Main {
    static int n;
    static int answer;
    static int[] col;
    public static void main(String[] args) throws Exception {
        input();
        answer = 0;
        recur(0);
        System.out.println(answer);


    }
    static void recur(int row){
        if(row==n){ //행의 맨 끝까지 옴
            answer++;
        }else{
            for (int c = 0; c < n ; c++) {
                //row행의 c열에 놓을 수 있다면 > valid check > row, c 에 대해 체크한다
                boolean flag = true;
                for (int i = 0; i <= row-1; i++) { //
                    // 위치는 (i, col[i])
                    if(attackable(row, c, i, col[i] )){
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    col[row] = c;
                    recur(row+1);
                    col[row] = 0;
                }
            }

        }
    }
    static boolean attackable(int r1, int c1, int r2, int c2){
        if(c1==c2) return true;
        if(r1+c1==r2+c2) return true;
        if(r1-c1 == r2-c2) return true;
        return false;
    }

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n];
    }
}