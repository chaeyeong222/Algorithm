import java.io.*;
import java.util.*;
class Main {
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n + 1];
        operator = new int[5];
        order = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        sb = new StringBuilder();
    }
    static int n,m;
    static int[] num, operator, order; //order 는 어떤순서로 연산자를 나열햇는지 = result
    static int min, max;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        input();
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);

    }
    static void rec_func(int k){ //재귀함수
        //만약 m개를 전부 고름 -> 조건에 맞는 탐색을 한가지 성공한 것
        //아직 m개를 전부 고르지 않음 -> k부터 m 번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다
        if(k==n){ //다 고름
            int value = calculator();
            max = Math.max(value, max);
            min = Math.min(value, min);
        }else{ //k번째 연산자는 뭘 선택?
            for (int i = 1; i < 5; i++) {
                if(operator[i] >=1) {
                    operator[i]--;
                    order[k] = i;
                    rec_func(k+1);
                    order[k]=0;
                    operator[i]++;
                }
            }
        }
    }
    static int calculator(){
        //nums, result
        int sum = num[1];
        for (int i = 1; i <= n-1; i++) {
            if(order[i]==1){ //+
                sum += num[i+1];
            }
            if(order[i]==2){ //-
                sum -= num[i+1];
            }
            if(order[i]==3){ //*
                sum *= num[i+1];
            }
            if(order[i]==4){ // /
                sum /= num[i+1];
            }
        }
        return sum;
        }
}