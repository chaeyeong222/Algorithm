import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int parentTrue; //진실을 알고 있는  집합의 사람들 사이의 부모인덱스
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //사람수
        int m = Integer.parseInt(st.nextToken());  //파티수
        parent = new int[n+1];
        //초기에는 자기 자신이 부모
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        
        parentTrue =0;//초기화
        st = new StringTokenizer(br.readLine());
        int participants = Integer.parseInt(st.nextToken());
        int[] truePeople = new int[participants];
        for (int i = 0; i < participants; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        }
        //진실을 알고있는 사람 집합 만들기
        for (int i = 0; i < participants-1; i++) {
            union(truePeople[i], truePeople[i+1]);
        }
        
        if(truePeople.length!=0){
            parentTrue = truePeople[0];
        }
        
        int[][] party = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            party[i] = new int[p];
            for (int j = 0; j < p; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < p-1; j++) {
                union(party[i][j], party[i][j+1]);
            } 
        }
        
        
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = 0; j < party[i].length; j++) {
                if(find(party[i][j])==parentTrue){
                    flag = true;
                    break;
                }
            }
            if(!flag) cnt++;
        }
        System.out.println(cnt);
        
        
        
        
    }
    public static int find(int a){
        if(parent[a]==a){
            return a;
        }
        return parent[a]=find(parent[a]);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a==parentTrue){
                parent[b] = a;
            }else if(b==parentTrue){
                parent[a] = b;
            }else{
                parent[b] =a;
            }
        }
    }
}