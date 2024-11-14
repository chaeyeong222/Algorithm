

import java.io.*;
import java.util.*;
//##
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int TC = 0; TC < T; TC++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //팀개수
            int k = Integer.parseInt(st.nextToken()); //문제개수
            int team = Integer.parseInt(st.nextToken()); // 구하는 팀
            int m = Integer.parseInt(st.nextToken()); // 로그수

            List<Team> list = new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                int[][] scoreArr = new int[k+1][2];
                Team t = new Team(i, scoreArr);
                list.add(t);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int question = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                /////////////////입력

                Team temp = list.get(id);

                temp.lastSubmitTime = i; //마지막 제출시간 갱신
                temp.submit+=1; //제출횟수 갱신
                int[][] checkScore = temp.eachScore;
                if(checkScore[question][1] < score){
                    temp.totalScore -= checkScore[question][1];
                    temp.totalScore += score; //토탈점수 갱신
                    temp.eachScore[question][1] = score; //해당값 갱신
                }
            }

            Collections.sort(list, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    //1. 총점수 내림차순
                    //2. 제출횟수 오름차순
                    //3. 제출시간 오름차순
                    if(o1.totalScore==o2.totalScore){
                        if(o1.submit==o2.submit){
                            return o1.lastSubmitTime-o2.lastSubmitTime;
                        }
                        return o1.submit-o2.submit;
                    }
                    return o2.totalScore - o1.totalScore;
                }
            });

            int answer = 1;
            for(Team tt : list){
                if(tt.teamId == team){
                    break;
                }else{
                    answer++;
                }
            }
            sb.append(answer).append('\n');

        }//tc
        System.out.println(sb);

    }
}
class Team{
    int teamId;
    int totalScore;
    int submit;
    int lastSubmitTime;
    int[][] eachScore;

    public Team(int teamId, int[][] eachScore){
        this.teamId = teamId;
        this.eachScore = eachScore;
    }
}