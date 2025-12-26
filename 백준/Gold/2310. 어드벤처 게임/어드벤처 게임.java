import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int room = Integer.parseInt(br.readLine());
        while (room!=0){
            List<Integer>[] list = new ArrayList[room+1];
            for (int j = 0; j <= room; j++) {
                list[j] = new ArrayList<>();
            }
            list[0].add(1); //맨처음1번방으로 감
            int[][] roomInfo = new int[room+1][2];
            for (int i = 1; i <= room; i++) {
                st = new StringTokenizer(br.readLine());
                String info = st.nextToken();
                int condition = Integer.parseInt(st.nextToken());
                if(info.equals("L")){
                    roomInfo[i][0] = 1;
                    roomInfo[i][1] = condition;
                }else if(info.equals("T")){
                    roomInfo[i][0] = 2;
                    roomInfo[i][1] = condition;
                }
                while(st.hasMoreTokens()){
                    int n = Integer.parseInt(st.nextToken());
                    if(n==0){
                        break;
                    }
                    list[i].add(n);
                }
            }//for

            //갈수있는지 체크
            int[] maxMoney = new int[room+1];
            Arrays.fill(maxMoney, -1);
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{0,0});
            boolean flag = false;
            while(!que.isEmpty()){
                int[] temp = que.poll();
                int now = temp[0];
                int hp = temp[1];
                if(now==room){
                    flag = true;
                    break;
                }
                for(int next : list[now]){
                    int nextMoney = 0;
                    if(roomInfo[next][0]==1){ //L인경우
                        nextMoney = Math.max(hp, roomInfo[next][1]);
                    }else if(roomInfo[next][0]==2){
                        if(hp < roomInfo[next][1]) continue;
                        nextMoney = hp - roomInfo[next][1];
                    }else{
                        nextMoney = hp;
                    }

                    if(nextMoney > maxMoney[next]){
                        maxMoney[next] = nextMoney;
                        que.offer(new int[]{next, nextMoney});
                    }
                }
            }
            if(flag) sb.append("Yes").append('\n');
            else sb.append("No").append('\n');

            room = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}