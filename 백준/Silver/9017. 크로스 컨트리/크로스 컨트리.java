import java.io.*;
import java.util.*;
//##9017 크로스컨트리
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int TC = 0; TC < T; TC++) {
            int n = Integer.parseInt(br.readLine());//총인원
            int[] num = new int[n];
            int[] team = new int[201]; //팀인원
            st = new StringTokenizer(br.readLine());
            //
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                team[num[i]]++;
                if(team[num[i]]==6) {
                    list.add(num[i]); 
                }
            }//1. 인원수 체크 >> 팀 제대로 들어가는 거 맞음
            //2. 점수체크
            int point = 1;
            int[][] scoreCheck = new int[201][4]; //0 은 사람수, 1은 4명까지의 합계, 2는 5번째 팀원의 점수, 3은 팀번호
            for (int i = 0; i < n; i++) {
                int now = num[i];
                if(list.contains(now)){//6명 이상인 팀이면
                    scoreCheck[now][0]++; //인원수 증가
                    scoreCheck[now][3]=now;
                    if(scoreCheck[now][0]<5){ //4명까지면 더해준다
                        scoreCheck[num[i]][1]+=point;
                    }else if(scoreCheck[now][0]==5){//5명째면 그 때의 포인트 체크
                        scoreCheck[now][2] = point;
                    }
                    point++;//포인트는 자동증가
                }
            }

            //정렬
            //1. 점수순, 2.5번재 인원의 등수 >> 둘다 오름차순 정렬
            Arrays.sort(scoreCheck, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] != o2[1]){
                        return o1[1]-o2[1]; //점수기준 정렬
                    }else{
                        return o1[2]-o2[2]; //5번째 팀원의 점수 오름차순 정렬
                    }
                }
            });

            int answer = -1;
            for (int i = 0; i < 201; i++) {
                if(scoreCheck[i][1]!=0){
                    answer = scoreCheck[i][3];
                    break;
                }
            }
            System.out.println(answer);
        }//TC
    }

}