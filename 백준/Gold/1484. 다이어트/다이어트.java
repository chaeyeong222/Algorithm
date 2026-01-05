import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=Math.sqrt(G); i++){
            //약수구하기
            if(G%i==0){
                int a = i;
                int b = G/a;
                if((a+b)%2 !=0) continue; //짝수아니면 제외

                int x = (a+b)/2;
                int y = (b-a)/2;
                if(y<=0) continue;
                list.add(x);

            }
        }

        if(list.size()==0) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            Collections.sort(list);
            for(int next: list){
                sb.append(next).append('\n');
            }
            System.out.println(sb);
        }

    }
}