import java.io.*;
import java.util.*;
//##공유기설치
class Main {
    static int n, m, ans;
    static int[] house;
    public static void main(String[] args) throws Exception {
        input();
        pro();

    }
    static void pro(){

        Arrays.sort(house);

        //start 와 end 범위 안에 정답이 존재한다.
        int start = 1;
//        int end = house[n-1]-house[0];
        int end = 1000000000;
        int ans = 0;

        while(start<=end){
            int mid = (start+end)/2;
            if(determination(mid)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(ans);


    }

    static boolean determination(int distance){
        //distance 만큼 거리차이를 뒀을때, m 만큼을 얻을 수 있으면 true, 아니면 false return
        //제일 왼쪽 집부터 가능한 많이 설치해보자
        //d만큼거리를 두면서 최대로 설치한 개수와 m를 비교
        int cnt = 1;
        int last = house[0]; // 마지막에 설치한 값
        for (int i = 1; i < n; i++) {
            //이번에 house[i]에 설치가 가능한다?
            if(house[i]-last >= distance){
                cnt++;
                last = house[i];
            }
        }
        return cnt >= m;

    }

    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
    }
}