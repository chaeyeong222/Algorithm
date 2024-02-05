
import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> board;
    static int[] score;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        board = new ArrayList<>(); //사진틀
        score = new int[k + 1];//추천수 - idx 가 학생번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            //
            int num = Integer.parseInt(st.nextToken());
            //이미 보드에 있는 애면?
            if (board.contains(num)) {
                score[num] += 1; 
                continue;
            }
            //보드에 없고, 보드에 자리가 남았으면
            if (board.size() < n) {
                board.add(num);
                score[num] = 1;

            }
            //보드에 없고, 자리없으면
            else {
                //한놈삭제
                deleteOne();
                //새로운 애 추가
                board.add(num);
                score[num] = 1;
            }
        }
        Collections.sort(board);
        for (int i = 0; i < board.size(); i++) {
            System.out.print (board.get(i)+" ");
        }

    }

    public static void deleteOne() {
        //보드에 있는 애 중 가장 크기 작은 애 찾기
        List<Integer> idx = new ArrayList<>();
        int min = 1001;//추천수
        for (int i = 0; i < board.size(); i++) {
            int temp = board.get(i); //보드에 있는 애 꺼내서
            //추천수 체크
            //제일 작은 애면
            if (score[temp] < min) {
                min = score[temp];
                //지금까지의 담아뒀던 통 비워주고 제일 작은 애 담기
                idx = new ArrayList<>();
                idx.add(temp);
            }
            //추천수 동일하게 작으면
            else if (score[temp] == min) {
                //통에 추가
                idx.add(temp);
            }
        }
        //여러개면 오래된 애 버리기
        if (idx.size() >= 1) {
            int old = idx.get(0); //제일 첫번째 애가 제일 작고 오래된 애임
            board.remove(Integer.valueOf(old)); //없애고
            score[old] = 0; //추천수도 0으로
        }

    }
}
