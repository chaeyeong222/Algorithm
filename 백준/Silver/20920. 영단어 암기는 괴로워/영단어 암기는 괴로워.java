import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Map<String, Integer> map;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>(){
            @Override
            public int compare(Word w1, Word w2){
                if(w1.cnt==w2.cnt && w1.length== w2.length){
                    return w1.w.compareTo(w2.w);
                }else if(w1.cnt==w2.cnt) return w2.length-w1.length;
                return w2.cnt - w1.cnt;
            }
        });
        for(String temp : map.keySet()){
            pq.offer(new Word(map.get(temp), temp.length(), temp));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll().w).append('\n');
        }
        System.out.println(sb);

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String t = br.readLine();
            if(t.length()>=M) map.put(t, map.getOrDefault(t,0)+1);
        }
    }
}
class Word{
    int cnt;
    int length;
    String w;
    Word(int cnt, int length, String w){
        this.cnt = cnt;
        this.length = length;
        this.w = w;
    }
}