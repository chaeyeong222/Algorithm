import java.io.*;
import java.util.*;
import javax.swing.Spring;
import javax.swing.text.ElementIterator;

//## 2251
class Main {
    static int N , M;
    static int[] limit;
    static List<Integer> list;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        set();
        pro(0,0,limit[2]);
        print();
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(' ');
        }
        System.out.println(sb);
    }
    static void pro(int x1, int x2, int x3){
        Queue<State> que = new LinkedList<>();
        que.add(new State(new int[]{0,0,limit[2]}));
        visited[x1][x2][x3]=true;
        while(!que.isEmpty()){
            State temp = que.poll();
            if(temp.x[0]==0 && !list.contains(temp.x[2]))list.add(temp.x[2]);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i==j) continue;
                    State next = temp.compare(i,j,limit);
                    if(visited[next.x[0]][next.x[1]][next.x[2]]) continue;
                    visited[next.x[0]][next.x[1]][next.x[2]] = true;
                    que.offer(new State(new int[]{next.x[0],next.x[1],next.x[2]}));
                }
            }
        }

    }


    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        visited = new boolean[202][202][202];
    }
}
class State{
    int[] x;
    State(int[] y){
        x = new int[3]; //복사
        for (int i = 0; i < 3; i++) {
            x[i] = y[i];
        }
    }
    public State compare(int from, int to, int[] limit){
        int[] nx = new int[]{x[0], x[1], x[2]};
        if(x[from]+x[to]>= limit[to]){
            nx[from] -= (limit[to]-x[to]);
            nx[to] = limit[to];
        }else{
            nx[to] += nx[from];
            nx[from] = 0;
        }
        return new State(nx);
    }
}