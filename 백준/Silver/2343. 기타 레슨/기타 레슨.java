import java.io.*;
import java.util.*;
//##기타 레슨
//매개변수 탐색으로 변환
class Main {
    static int N , M;
    static int[] record;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    static void pro(){
        int start = 1;
        int end = 1000000000;
        while (start<=end){
            int mid = (start+end)/2;
            if(possible(mid)){
                answer = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
    }

    static boolean possible(int size) {
        int cnt = 1; // 필요한 블루레이 개수
        int sum = 0; // 현재 블루레이에 담긴 강의 길이의 합
        for (int i = 0; i < N; i++) {
            if (record[i] > size) return false; // 강의가 블루레이 크기보다 크면 불가능
            if (sum + record[i] > size) {
                cnt++; // 블루레이를 추가
                sum = record[i]; // 현재 강의를 새 블루레이에 담음
            } else {
                sum += record[i]; // 현재 블루레이에 강의를 추가
            }
        }
        return cnt <= M; // 블루레이 개수가 M 이하인지 확인
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        record = new int[N];
        for (int i = 0; i < N; i++) {
            record[i] = Integer.parseInt(st.nextToken());
        }
    }
}