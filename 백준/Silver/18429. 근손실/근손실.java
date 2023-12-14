import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,k, cnt;
    static int[] power, turn;
    static boolean[] visited;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        power = new int[n]; //중량
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
        turn = new int[n]; //순서
        visited = new boolean[n];
        makeTurn(0);
        System.out.println(cnt);


    }
    public static void makeTurn(int depth){
        //탈출조건: depth 가 n 이면 탈출
        if(depth==n){
            //여기서 순서마다 500을 유지할 수 있는지 체크하고, 끝까지 유지된다면 cnt 올려주기
            if(checkPower()) {
                cnt++;
            }  
            return;
        }
        //현재 depth 에 방문하지 않은 숫자 채워줌.
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                turn[depth] = power[i]; //순서넣어주기
                visited[i] = true; //방문체크
                makeTurn(depth+1);//다음 depth 채워주기
                visited[i] = false;
            }
        }

    }//
    public static boolean checkPower(){
        int nowPower = 500;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            nowPower = nowPower - k + turn[i];
            if(nowPower<500) flag=false;
        }
        return flag;
    }
}
