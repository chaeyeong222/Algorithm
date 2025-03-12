import java.io.*;
import java.util.*;

//##2564경비원
//1북2남3서4동
//북남>왼~
//동서>위~
//동근 위치
class Main {
    static int[][] position;
    static int garo, sero, k, totalDist;
    static int r, c; //동근위치
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calDist(i);
        }
        System.out.println(sum);
    }
    public static int calDist(int idx){
        int dong = getPos(r,c);
        int store = getPos(position[idx][0], position[idx][1]);
        return Math.min(Math.abs(dong-store), totalDist-Math.abs(dong-store));
    }
    public static int getPos(int dir, int x){ // 직사각형 경계를 1차원으로 변환
        if(dir==1) return x;//북
        if(dir==2) return garo+sero+(garo-x); //남
        if(dir==3) return garo+sero+garo+(sero-x); //서
        return garo+x; //동
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        garo = Integer.parseInt(st.nextToken());
        sero = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        position = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                position[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        totalDist = garo*2 + sero*2;
    }
}
