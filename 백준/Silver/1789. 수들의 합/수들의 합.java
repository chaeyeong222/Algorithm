import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long goal = Long.parseLong(br.readLine());
        int answer = 0;
        int num = 1;
        while(goal>0){
            goal-=num;
            num++;
            if(goal-num<0){
                answer = num-1;
                break;
            }
        }
        System.out.println(answer);
        
    }
}