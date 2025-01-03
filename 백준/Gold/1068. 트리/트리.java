import java.io.*;
import java.util.*; 
class Main {
    static int N;
    static int[] leaf;
    static List<Integer>[] child;
    static int root, erased;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        //자식중에 erased가 있는 애를 찾아서 지워준다.
        for (int i = 0; i < N; i++) {
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if(root != erased){
            dfs(root);
        }
        System.out.println(leaf[root]);
    }
    public static void dfs(int x){
        if(child[x].isEmpty()){
            leaf[x] = 1;
        }
        for( int y : child[x]){
            dfs(y);
            ////////// leaf[y]가 계산된 상태
            leaf[x] += leaf[y];
        }
    }

    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        child = new ArrayList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1){
                root = i;
                continue;
            }
            child[parent].add(i);
        }

        erased = Integer.parseInt(br.readLine());

    }
}