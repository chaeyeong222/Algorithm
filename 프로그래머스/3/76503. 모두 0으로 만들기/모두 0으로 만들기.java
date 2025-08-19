import java.util.*;

class Solution {
    List<Integer>[] list;
    long[] a;   // int → long
    long answer; 

    public long solution(int[] a, int[][] edges) {
        // int[] → long[] 복사
        this.a = new long[a.length];
        for (int i = 0; i < a.length; i++) this.a[i] = a[i];

        answer = 0;

        long sum = 0;
        for (long v : this.a) sum += v;
        if (sum != 0) return -1;

        list = new ArrayList[a.length];
        for (int i = 0; i < a.length; i++) list[i] = new ArrayList<>();
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        find(0);
        return answer;
    }

    public void find(int idx) {
        Stack<int[]> stack = new Stack<>(); // {node, parent}
        stack.push(new int[]{idx, -1});
        
        List<int[]> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int node = cur[0], parent = cur[1];
            order.add(cur);
            for (int next : list[node]) {
                if (next == parent) continue;
                stack.push(new int[]{next, node});
            }
        }
        
        for (int i = order.size() - 1; i >= 0; i--) {
            int node = order.get(i)[0];
            int parent = order.get(i)[1];
            if (parent != -1) {
                a[parent] += a[node];          // long 누적
                answer += Math.abs(a[node]);   // 연산 횟수 누적
                a[node] = 0;
            }
        }
    }
}
