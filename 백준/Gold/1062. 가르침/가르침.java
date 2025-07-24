import java.io.*;
import java.util.*;
class Main {
    static int N,K;
    static int[] word;
    static List<Integer> candidates;
    static int answer;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro() {
        if(K<5){
            System.out.println(0);
            return;
        }

        if(K == 5) {
            int knownMask = 0;
            for(char c : "antic".toCharArray()){
                knownMask |= (1 << (c - 'a'));
            }
            checkWord(knownMask);
            System.out.println(answer);
            return;
        }
        if(candidates.size() < K - 5){
            int knownMask = 0;
            for(char c : "antic".toCharArray()){
                knownMask |= (1<<(c-'a'));
            }
            for(int cand : candidates){
                knownMask |= (1 << cand);
            }
            checkWord(knownMask);
            System.out.println(answer);
            return;
        }
         

        boolean[] visit = new boolean[candidates.size()];
        dfs(0,K-5, 0,visit);
        System.out.println(answer);
    }
    public static void dfs(int idx, int k, int depth, boolean[] visited){
        if(depth==k){
            int knownMask = 0;
            for(char c : "antic".toCharArray()){
                knownMask |= (1<<(c-'a'));
            }
            for (int i = 0; i < candidates.size(); i++) {
                if(visited[i]){
                    knownMask |= (1<<candidates.get(i));
                }
            }
            checkWord(knownMask);
            return;
        }
        for (int i = idx; i < candidates.size(); i++) {
            visited[i] = true;
            dfs(i+1, k, depth+1, visited);
            visited[i] = false;
        }

    }
    public static void checkWord(int knownMask){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if((word[i] & knownMask) == word[i]){
                cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        word = new int[N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            int bitmask = 0;
            for(char c : temp.toCharArray()){
                if("antic".indexOf(c)!=-1) continue;//기본 5글자 제외
                int t = 1<<(c-'a');
                bitmask |= t;
                set.add(c-'a');
            }
            word[i] = bitmask;
        }
        candidates = new ArrayList<>(set);
    }
}