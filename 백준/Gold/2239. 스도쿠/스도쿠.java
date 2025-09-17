import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] row;
    static boolean[][] col;
    static boolean[][] box;
    static List<int[]> blanks;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        set();
        pro();
    }
    public static void pro(){
        dfs(0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }sb.append('\n');
        }
        System.out.println(sb);
        
    }
    public static void dfs(int idx){
        if(flag) return;//이미 끝
        if(idx==blanks.size()){
            flag = true;
            return;
        }

        int r = blanks.get(idx)[0];
        int c = blanks.get(idx)[1];
        int b = (r/3)*3 + (c/3);

        for (int i = 1; i <= 9; i++) {
            if(row[r][i] || col[c][i] || box[b][i] ) continue;
            
            map[r][c] = i;
            row[r][i] = true;
            col[c][i] = true;
            box[b][i] = true;
            
            dfs(idx+1);
            
            if(flag) return;
            map[r][c] = 0;
            row[r][i] = false;
            col[c][i] = false;
            box[b][i] = false;
            
        }
    }
    public static void set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        row = new boolean[9][10];
        col = new boolean[9][10];
        box = new boolean[9][10];
        blanks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = temp.charAt(j) -'0';
                map[i][j] = num;
                if(num==0){
                    blanks.add(new int[]{i,j});
                }else{
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i/3)*3+(j/3)][num] = true;
                }
            }
        }
    }

}