import java.util.*;
import java.io.*;

//
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//세로
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        //내림차순정렬
        Collections.sort(list, Collections.reverseOrder());
        //3개씩묶어서 마지막거 지우기
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if((i+1)%3!=0) {
                answer+=list.get(i);
            }
        }
        System.out.println(answer);
    }

}
