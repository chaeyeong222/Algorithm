import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        System.out.println(answer);
    }
    public static void pro(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int temp = version1(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);

                temp = version2(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);

                temp = version3(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);

                temp = version4(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);

                temp = version5(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version6(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version7(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version8(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version9(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version10(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version11(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version12(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version13(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version14(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version15(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version16(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version17(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version18(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
                temp = version19(i,j);
                if(temp!=-1) answer = Math.max(answer, temp);
            }
        }
    }
    public static int version19(int r, int c) { //ㅗ자(4)
        int sum = 0;
        for (int i = r; i < r+3; i++) {
            if(!rangeCheck(i,c+1)) return -1;
            else sum+=map[i][c+1];
        }
        if(!rangeCheck(r+1,c)) return -1;
        else sum+=map[r+1][c];
        return sum;
    }
    public static int version18(int r, int c) { //ㅗ자(3 )
        int sum = 0;
        for (int i = r; i < r+3; i++) {
            if(!rangeCheck(i,c)) return -1;
            else sum+=map[i][c];
        }
        if(!rangeCheck(r+1,c+1)) return -1;
        else sum+=map[r+1][c+1];
        return sum;
    }
    public static int version17(int r, int c) { //ㅗ자(2)
        int sum = 0;
        for (int i = c; i < c+3; i++) {
            if(!rangeCheck(r,i)) return -1;
            else sum+=map[r][i];
        }
        if(!rangeCheck(r+1,c+1)) return -1;
        else sum+=map[r+1][c+1];
        return sum;
    }
    public static int version16(int r, int c) { //ㅗ자(1)
        int sum = 0;
        for (int i = c; i < c+3; i++) {
            if(!rangeCheck(r+1,i)) return -1;
            else sum+=map[r+1][i];
        }
        if(!rangeCheck(r,c+1)) return -1;
        else sum+=map[r][c+1];
        return sum;
    }
    public static int version15(int r, int c) { //ㄹ자(4)
        int sum = 0;
        if (!rangeCheck(r+1, c)) return -1;
        else sum += map[r+1][c];
        if (!rangeCheck(r+2, c+1)) return -1;
        else sum += map[r+2][c+1];
        if (!rangeCheck(r+1, c+1)) return -1;
        else sum += map[r+1][c+1];
        if (!rangeCheck(r, c)) return -1;
        else sum += map[r][c];
        return sum;
    }
    public static int version14(int r, int c) { //ㄹ자(3)
        int sum = 0;
        if (!rangeCheck(r+1, c)) return -1;
        else sum += map[r+1][c];
        if (!rangeCheck(r, c+1)) return -1;
        else sum += map[r][c+1];
        if (!rangeCheck(r+1, c+1)) return -1;
        else sum += map[r+1][c+1];
        if (!rangeCheck(r+2, c)) return -1;
        else sum += map[r+2][c];
        return sum;
    }
    public static int version13(int r, int c) { //ㄹ자(2)
        int sum = 0;
        if (!rangeCheck(r+1, c)) return -1;
        else sum += map[r+1][c];
        if (!rangeCheck(r, c+1)) return -1;
        else sum += map[r][c+1];
        if (!rangeCheck(r+1, c+1)) return -1;
        else sum += map[r+1][c+1];
        if (!rangeCheck(r, c+2)) return -1;
        else sum += map[r][c+2];
        return sum;
    }
    public static int version12(int r, int c) { //ㄹ자(1)
        int sum = 0;
        if (!rangeCheck(r, c)) return -1;
        else sum += map[r][c];
        if (!rangeCheck(r, c+1)) return -1;
        else sum += map[r][c+1];
        if (!rangeCheck(r+1, c+1)) return -1;
        else sum += map[r+1][c+1];
        if (!rangeCheck(r+1, c+2)) return -1;
        else sum += map[r+1][c+2];
        return sum;
    }

    public static int version11(int r, int c){ //L자(8)
        int sum = 0;
        for (int i = c; i < c+3; i++) {
            if(!rangeCheck(r,i)) return -1;
            else sum += map[r][i];
        }
        if(!rangeCheck(r+1,c+2)) return -1;
        else sum+=map[r+1][c+2];
        return sum;
    }
    public static int version10(int r, int c){ //L자(7)
        int sum = 0;
        for (int i = c; i < c+3; i++) {
            if(!rangeCheck(r,i)) return -1;
            else sum += map[r][i];
        }
        if(!rangeCheck(r+1,c)) return -1;
        else sum+=map[r+1][c];
        return sum;
    }
    public static int version9(int r, int c){ //L자(6)
        int sum = 0;
        for (int i = c; i < c+3; i++) {
            if(!rangeCheck(r+1,i)) return -1;
            else sum += map[r+1][i];
        }
        if(!rangeCheck(r,c+2)) return -1;
        else sum+=map[r][c+2];
        return sum;
    }
    public static int version8(int r, int c){ //L자(5)
        int sum = 0;
        for (int i = c; i < c+3; i++) {
            if(!rangeCheck(r+1,i)) return -1;
            else sum += map[r+1][i];
        }
        if(!rangeCheck(r,c)) return -1;
        else sum+=map[r][c];
        return sum;
    }

    public static int version7(int r, int c){ //L자(4)
        int sum = 0;
        for (int i = r; i < r+3; i++) {
            if(!rangeCheck(i,c+1)) return -1;
            else sum += map[i][c+1];
        }
        if(!rangeCheck(r+2,c)) return -1;
        else sum+=map[r+2][c];
        return sum;
    }

    public static int version6(int r, int c){ //L자(3)
        int sum = 0;
        for (int i = r; i < r+3; i++) {
            if(!rangeCheck(i,c+1)) return -1;
            else sum += map[i][c+1];
        }
        if(!rangeCheck(r,c)) return -1;
        else sum+=map[r][c];
        return sum;
    }


    public static int version5(int r, int c){ //L자(2)
        int sum = 0;
        for (int i = r; i < r+3; i++) {
            if(!rangeCheck(i,c)) return -1;
            else sum += map[i][c];
        }
        if(!rangeCheck(r,c+1)) return -1;
        else sum+=map[r][c+1];
        return sum;
    }

    public static int version4(int r, int c){ //L자(1)
        int sum = 0;
        for (int i = r; i < r+3; i++) {
            if(!rangeCheck(i,c)) return -1;
            else sum += map[i][c];
        }
        if(!rangeCheck(r+2,c+1)) return -1;
        else sum+=map[r+2][c+1];
        return sum;
    }
    public static int version3(int r, int c){ //ㅁ자
        int sum = 0;
        for (int i = r; i < r+2; i++) {
            for (int j = c; j < c+2; j++) {
                if(!rangeCheck(i,j)){
                    return -1;
                }else {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
    public static int version2(int r, int c){ //ㅣ자(2)
        int sum = 0;
        for (int i = r; i < r+4; i++) {
            if(!rangeCheck(i,c)){
                return -1;
            }else {
                sum += map[i][c];
            }
        }
        return sum;
    }
    public static int version1(int r, int c){ // ㅣ자(1)
        int sum = 0;
        for (int i = c; i < c+4; i++) {
            if(!rangeCheck(r,i)){
                return -1;
            }else {
                sum += map[r][i];
            }
        }
        return sum;
    }

    public static boolean rangeCheck(int r, int c){
        if(r>=0 && c>=0 && r<R && c<C){
            return true;
        }
        return false;
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}