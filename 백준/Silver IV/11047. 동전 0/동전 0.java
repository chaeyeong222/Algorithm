import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int money = scan.nextInt();
        Stack<Integer> coins = new Stack<>();
        for (int i = 0; i < n; i++) {
            int check = scan.nextInt();
            if(check <= money){
                coins.push(check);
            }else{
                break;
            }
        }
        int cnt = 0;
        while (money > 0 && !coins.isEmpty()){
            cnt += (money/coins.peek());
            money %= coins.pop();
        }
        System.out.println(cnt);


    }
}