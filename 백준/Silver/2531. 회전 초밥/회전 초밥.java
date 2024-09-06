import org.omg.CORBA.MARSHAL;

import javax.security.auth.callback.TextInputCallback;
import java.awt.*;
import java.io.*;
import java.util.*;
//#2531 회전초밥
class Main {
    static Map<Integer, Integer> map;
    static  int n, k, bonus;
    static int[] belt;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //벨트상태
        int type = Integer.parseInt(st.nextToken()); //초밥가짓수
        k = Integer.parseInt(st.nextToken()); // 연속접시
        bonus = Integer.parseInt(st.nextToken()); //쿠폰번호
        belt = new int[n];
        boolean bonusInBelt = false;
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
            if(belt[i]==bonus) bonusInBelt = true;
        }//입력

        answer = 0;
        //k만큼 범위 체크 > Map에 담는다 가짓수 체크
        //벨트 위에 쿠폰초밥 유무는 입력받을 때 체크
        //만약 벨트 위에 쿠폰이 없다면? >> 가짓수 +1
        // 벭트 위에 있다면? >> 쿠폰을 포함하지 않는 세트의 최대를 찾아야 함.
        //start =0 으로 다시 돌아올때 까지 체크

        map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(belt[i], map.getOrDefault(belt[i], 0) + 1);
        }
        answer = map.size();

        checkSushi(0,k, bonusInBelt); 
        System.out.println(answer); 


    }
    public static void checkSushi(int start, int end, boolean existed){
        // 끝에오면 맨 처음으로 돌려준다
        if(end==n) end = 0;
        if(start==n) return;//start 가 맨 처음으로 오면 로직 종료

        //맨처음값 없애
        if(map.containsKey(belt[start])) {
            if(map.get(belt[start])==1) {
                map.remove(belt[start]);
            }else {
                map.put(belt[start], map.get(belt[start])-1); //교체
            }
        }
        //마지막 값
        map.put(belt[end], map.getOrDefault(belt[end],0)+1);

        //값 갱신하고
        if(existed && map.containsKey(bonus) ){ answer = Math.max(answer,  map.size());
        }else  answer = Math.max(answer, map.size()+1);
        checkSushi(start+1, end+1, existed);
    }
}