import java.util.*;
class Solution {
    int[] parent;
    int[] inDegree;
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        int maxIdx = 0;
        for(int node : nodes){
            maxIdx = Math.max(node, maxIdx);
        }
        parent = new int[maxIdx+1];
        inDegree = new int[maxIdx+1];
        for(int i=0; i<=maxIdx; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            inDegree[a]++;
            inDegree[b]++;
            union(a,b);
        }
        Map<Integer, TreeInfo> map = new HashMap<>();
        for(int node : nodes){
            int mainNode = find(node);
            
            TreeInfo t = map.getOrDefault(mainNode, new TreeInfo());
            if((node%2==0) && (inDegree[node]%2==0)){
                t.evenNode++;
            }else if((node%2==1) && (inDegree[node]%2==1)){
                t.oddNode++;
            }else if((node%2==0) && (inDegree[node]%2==1)){
                t.reverseEvenNode++;
            }else if((node%2==1) && (inDegree[node]%2==0)){
                t.reverseOddNode++;
            }
            map.put(mainNode, t);
        }
        
        int tree = 0;
        int reTree = 0;
        for(TreeInfo treeInfo : map.values()){
            if(treeInfo.isTree()){
                answer[0]++;
            }
            if(treeInfo.isReverseTree()){
                answer[1]++;
            }
        }
        
        return answer;
    }
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
        
    }
    public int find(int a){
        if(parent[a]!=a){
            return parent[a] = find(parent[a]);
        }
        return a;
    }
}
class TreeInfo{
    int oddNode;
    int evenNode;
    int reverseOddNode;
    int reverseEvenNode;
    public TreeInfo(){
        this.oddNode = 0;
        this.evenNode = 0;
        this.reverseOddNode = 0;
        this.reverseEvenNode = 0;
    }
    public boolean isTree(){
        if((oddNode==1 && evenNode==0) || (oddNode==0 && evenNode==1)){
            return true;
        }
        return false;
    }
    public boolean isReverseTree(){
        if((reverseOddNode==1 && reverseEvenNode==0) || (reverseOddNode==0 && reverseEvenNode==1)){
            return true;
        }
        return false;
    }
}
