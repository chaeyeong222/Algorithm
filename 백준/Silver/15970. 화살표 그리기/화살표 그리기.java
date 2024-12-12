import java.io.*;
import java.util.*;
//##15970 화살표 그리기
class Main {
    static int n;
    static List<Integer>[] list;
    static int answer; 
    public static void main(String[] args) throws Exception {
        set(); 
        findSum();
        System.out.println(answer);

    }
    static void findSum(){
        for (int i = 0; i < list.length; i++) {
            int k = list[i].size();
            Collections.sort(list[i]);
            for (int j = 0; j < k; j++) {
                if(j==0){
                    answer+=(list[i].get(1)-list[i].get(0));
                }else if(j==k-1){
                    answer+=(list[i].get(k-1) - list[i].get(k-2) );
                }else{
                    answer += Math.min(list[i].get(j) - list[i].get(j-1) ,list[i].get(j+1) - list[i].get(j));
                } 
            } 
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            list[color].add(point);
        }
    }
}