import java.io.*;
import java.util.*;

public class Main {
    public static int limit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int player = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        //닉네임 별 레벨을 담을 map
        Map<String, Integer> map = new HashMap<>();
        //담아줄 pq
        List<Room> list = new ArrayList<>();
        int idx = 1;
        for (int i = 0; i < player; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            map.put(nickname, level);
            if(list.size()==0){ //맨처음
                Room newroom = new Room(idx++, level-10, level+10);
                newroom.players.add(nickname);
                list.add(newroom);
                continue;
            }
            //생성된 방들이 있는 경우
            boolean flag = false;
            for (Room r : list){
                //자리남음
                if(r.players.size()<limit && r.minusLevel <= level && level<=r.plusLevel) { //방이 비어있고 들어갈 수 있는 상태라면
                    r.players.add(nickname);
                    flag = true;
                    break;
                }
            }
            if(!flag){ //새로운 방 만들어야함
                Room newroom = new Room(idx++, level-10, level+10);
                newroom.players.add(nickname);
                list.add(newroom);
            }
        } //입력 끝

        //출력
        StringBuilder sb = new StringBuilder();
//        while(!pq.isEmpty()){
//            Room temp = pq.poll();
//        }

//        for (Room rr : list){
//            if(rr.players.size()==limit){
//                sb.append("Started!").append('\n');
//                for (String nick : rr.players){
//                    sb.append(map.get(nick)).append(" ").append(nick).append('\n');
//                }
//            }else{
//                sb.append("Waiting!").append('\n');
//                for (String nick : rr.players){
//                    sb.append(map.get(nick)).append(" ").append(nick).append('\n');
//                }
//            }
//        }

        for (int i = 0; i < list.size(); i++) {
            Room rr = list.get(i);
            if(rr.players.size()==limit){
                sb.append("Started!").append('\n');
                Collections.sort(rr.players);
                for (String nick : rr.players){
                    sb.append(map.get(nick)).append(" ").append(nick).append('\n');
                }
            }else{
                sb.append("Waiting!").append('\n');
                Collections.sort(rr.players);
                for (String nick : rr.players){
                    sb.append(map.get(nick)).append(" ").append(nick).append('\n');
                }
            }
        }
        System.out.println(sb);



    }
}
class Room{
    int makeIdx;//생성된 순서
    int minusLevel; //입장가능 최소레벨
    int plusLevel; //입장가능 최대레벨
    int roomNum;
    List<String> players =  new ArrayList<>();
    Room(int makeIdx, int minusLevel, int plusLevel){
        this.makeIdx = makeIdx;
        this.minusLevel = minusLevel;
        this.plusLevel = plusLevel;
    }
}