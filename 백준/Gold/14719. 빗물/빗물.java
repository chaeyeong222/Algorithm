import java.util.*;
import java.io.*;

//
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());//세로
        int w = Integer.parseInt(st.nextToken());//가로
        int[] rain = new int[w];
        st = new StringTokenizer(br.readLine());
        int maxHIdx = 0;
        for (int i = 0; i < w; i++) {
            rain[i] = Integer.parseInt(st.nextToken());
            if (rain[i] >= rain[maxHIdx]) maxHIdx = i;
        }

        int answer = 0;

        //왼쪽부터 기준이 될 높이 체크
        int startH = rain[0];
        int sidx = 0;
        if (startH == 0) {
            while (startH == 0 && sidx < maxHIdx) {
                sidx++;
                startH = rain[sidx];
            }
        }


        for (int i = sidx; i < maxHIdx; i++) {
            if (rain[i] >= startH) {
                startH = rain[i];//기준바꿔주기
            } else {
                answer += (startH - rain[i]);
            }
        }


        int endH = rain[w - 1];
        int eidx = w - 1;
        if (endH == 0) {
            while (endH == 0 && eidx > maxHIdx) {
                eidx--;
                endH = rain[eidx];
            }
        }


        for (int i = eidx; i > maxHIdx; i--) {
            if (rain[i] >= endH) {
                endH = rain[i];
            } else {
                answer += (endH - rain[i]);
            } 
        }
        System.out.println(answer);

    }

}
