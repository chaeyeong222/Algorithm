import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] num, sortedNum;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        for(int value : num){
            sb.append(map.get(value)).append(' ');
        }
        System.out.println(sb);

    }
    public static void pro() {
        Arrays.sort(sortedNum);
        int rank = 0;
        for(int value : sortedNum){
            if(!map.containsKey(value)){
                map.putIfAbsent(value, rank++);
            }
        }
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        sortedNum = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sortedNum[i] = num[i];
        }
    }
}