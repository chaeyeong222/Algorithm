import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static int r,c,k, nowR, nowC, maxR, maxC;
    static int[][] num;
    static int time;
    static int answer = -1;
    public static void main(String[] args) throws Exception{
        set();
        pro();
    }
    public static void pro(){

        //초 체크 and 값 체크
        while(time<=100){
            if(rangeCheck()){
                System.out.println(time);
                return;
            }
            if (time == 100) { //백초가 지나면 끝
                break;
            } 
            //정렬 + 행열 max 갱신
            if(nowR>=nowC){
                changeR();
            }else{
                changeC();
            }
            time++; 
        }
        System.out.println(-1);
    }
    public static boolean rangeCheck(){ //값체크
        if(r<nowR && c<nowC && num[r][c]==k) {
            answer = time;
            return true;
        }
        return false;
    }
    public static void changeC(){
        int maxR = 0;
        //바구니
        List<Integer>[] list = new ArrayList[nowC];
        for (int i = 0; i < nowC; i++) {
            list[i] = new ArrayList<>();
        }
        Map<Integer, Integer> map; //개수셈
        PriorityQueue<Array> pq;
        for (int i = 0; i < nowC; i++) {
            map = new HashMap<>();
            pq = new PriorityQueue<>(new Comparator<Array>() {
                @Override
                public int compare(Array o1, Array o2) {
                    if(o1.cnt==o2.cnt){
                        return o1.num-o2.num;
                    }
                    return o1.cnt-o2.cnt;
                }
            });
            for (int j = 0; j < nowR; j++) {
                if(num[j][i]==0) continue;
                map.put(num[j][i], map.getOrDefault(num[j][i],0)+1);
            }

            for(Entry<Integer,Integer> es : map.entrySet()){
                pq.offer(new Array(es.getKey(), es.getValue()));
            }

            while(!pq.isEmpty()){
                Array p = pq.poll();
                list[i].add(p.num);
                list[i].add(p.cnt);
            }
            maxR = Math.max(maxR, list[i].size());
        }
        maxR = Math.min(maxR, 100);
        int[][] tempNum = new int[maxR][nowC];
        for (int i = 0; i < nowC; i++) {
            for (int j = 0; j < Math.min(list[i].size(), maxR); j++) {
                tempNum[j][i] = list[i].get(j);
            }
        }
        num = tempNum;
        nowR = Math.min(maxR,100);
    }
    public static void changeR(){
        int maxC = 0;
        //바구니
        List<Integer>[] list = new ArrayList[nowR];
        for (int i = 0; i < nowR; i++) {
            list[i] = new ArrayList<>();
        }
        Map<Integer, Integer> map; //개수셈
        PriorityQueue<Array> pq;
        for (int i = 0; i < nowR; i++) {
            map = new HashMap<>();
            pq = new PriorityQueue<>(new Comparator<Array>() {
                @Override
                public int compare(Array o1, Array o2) {
                    if(o1.cnt==o2.cnt){
                        return o1.num-o2.num;
                    }
                    return o1.cnt-o2.cnt;
                }
            });
            for (int j = 0; j < nowC; j++) {
                if(num[i][j]==0) continue;
                map.put(num[i][j], map.getOrDefault(num[i][j],0)+1);
            }

            for(Entry<Integer,Integer> es : map.entrySet()){
                pq.offer(new Array(es.getKey(), es.getValue()));
            }

            while(!pq.isEmpty()){
                Array p = pq.poll();
                list[i].add(p.num);
                list[i].add(p.cnt);
            }
            maxC = Math.max(maxC, list[i].size());
        }
        maxC = Math.min(maxC, 100);
        int[][] tempNum = new int[nowR][maxC];
        for (int i = 0; i < nowR; i++) {
            for (int j = 0; j < Math.min(list[i].size(), maxC); j++) {
                tempNum[i][j] = list[i].get(j);
            }
        }
        num = tempNum;
        nowC = Math.min(maxC,100);
    }
    public static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());
        num = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        time = 0;
        nowR = 3; nowC = 3;

    }
}
class Array{
    int num;
    int cnt;
    public Array(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}