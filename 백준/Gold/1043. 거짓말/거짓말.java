import java.io.*;
import java.util.*;
//## 거짓말
class Main {
    static int[] parent;
    static int truthParent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //사람수
        int m = Integer.parseInt(st.nextToken()); //파티수
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int[] truePeople = new int[k];
        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) { //초기에는 자기 자신이 부모
            parent[i] = i;
        }
        for (int i = 0; i < k; i++) {  //진실을 아는 사람들
            truePeople[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k-1; i++) { //아는사람들끼리 모아주기
            union(truePeople[i],truePeople[i+1]);
        }
        truthParent = 0;
        if(truePeople.length!=0){ //진실을 아는 사람이 있다면
            truthParent = find(truePeople[0]);
        }
        //거짓말가능한 그룹 체크
        int[][] people = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int group = Integer.parseInt(st.nextToken());

            people[i] = new int[group];
            for (int j = 0; j < group; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
            //파티에서 진실을 알게될 사람들
            for (int j = 0; j < group-1; j++) {
                union(people[i][j] , people[i][j+1]);
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < people[i].length; j++) {
                if(find(people[i][j])==truthParent){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;

        }
        System.out.println(answer);
        
        
        
        
    }
    static int find(int x){
        if(parent[x] == x) return x;
        else {
            return parent[x] = find(parent[x]);
        }
    }
    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px!=py){
            if(px == truthParent){
                parent[py] = px;
            }else if(py==truthParent){
                parent[px] = py;
            }else{
                parent[py] = px;
            }
        }
    }
}