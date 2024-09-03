import java.io.*;
import java.util.*;
//#숨바꼭질
public class Main {
    static int sis;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        sis = Integer.parseInt(st.nextToken());
        cnt =  Integer.MAX_VALUE;
        findSis(me,0);
        System.out.println(cnt);
    }

    public static void findSis(int nowSpot, int time){
        boolean[] visited = new boolean[100001];
        Queue<int[]> que = new LinkedList<>();//0현재위치, 1횟수
        que.offer(new int[]{nowSpot, time});
        visited[nowSpot] = true;
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(now[0]==sis) {
//                cnt = Math.min(now[1], cnt);
                cnt = now[1];
            }
            if(now[0]*2 <=100000 && !visited[now[0]*2]) {
                visited[now[0]*2]= true;
                que.offer(new int[]{now[0]*2, now[1]});
            }
            if(now[0]-1>=0 && !visited[now[0]-1]) {
                visited[now[0]-1]= true;
                que.offer(new int[]{now[0]-1, now[1]+1});
            }
            if(now[0]+1 <=100000 && !visited[now[0]+1]) {
                visited[now[0]+1]= true;
                que.offer(new int[]{now[0]+1, now[1]+1});
            }

        }
    }
}