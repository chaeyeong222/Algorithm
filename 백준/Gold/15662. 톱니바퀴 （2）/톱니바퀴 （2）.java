import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static String[] wheel;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        set();
        pro();
        print();
    }
    public static void print(){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(wheel[i].charAt(0)=='1'){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void pro() throws Exception{
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int pivot = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            List<int[]> moveList = move(pivot-1, direction);
            StringBuilder sb;
            for(int[] ll : moveList){
                int idx = ll[0];
                int dir = ll[1];
                if(dir==1){
                    sb = new StringBuilder();
                    String s1 = wheel[idx].substring(0,7);
                    String s2 = wheel[idx].charAt(7)+"";
                    wheel[idx] = sb.append(s2).append(s1).toString();
                }else{
                    sb = new StringBuilder();
                    String s1 = wheel[idx].substring(1);
                    String s2 = wheel[idx].charAt(0)+"";
                    wheel[idx] = sb.append(s1).append(s2).toString();
                }
            }
        }
    }
    public static List<int[]> move(int pivot, int direction){
        List<int[]> moveList = new ArrayList<>();
        moveList.add(new int[]{pivot, direction});

        int dir = direction;
        //left

        for (int i = pivot-1; i >= 0; i--) {
            if(wheel[i].charAt(2)!=wheel[i+1].charAt(6)){
                dir*=-1;
                moveList.add(new int[]{i, dir});
            }else {
                break;
            }
        }
        dir = direction;

        for (int i = pivot+1; i < N; i++) {
            if(wheel[i-1].charAt(2)!=wheel[i].charAt(6)){
                dir*=-1;
                moveList.add(new int[]{i, dir});
            }else {
                break;
            }
        }
        return moveList;
    }
    public static void set() throws Exception{
        N = Integer.parseInt(br.readLine());
        wheel = new String[N];
        for (int i = 0; i < N; i++) {
            wheel[i] = br.readLine();
        }
        T = Integer.parseInt(br.readLine());
    }
}