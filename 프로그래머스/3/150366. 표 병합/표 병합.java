import java.util.*;
import java.io.*;
class Solution {
    public int[] parent;
    public String[] value;
    public List<String> answer;
    public List<String> solution(String[] commands) {
        answer = new ArrayList<>(); 
        parent = new int[2501];
        value=new String[2501];  
        for(int i=1; i<=2500; i++){
            parent[i] = i;
        } 
        
        for(String command : commands){
            String[] word = command.split(" ");
            switch(word[0]){
                case "UPDATE":
                    if(word.length==4) updateCell(word);
                    else updateValue(word[1], word[2]);
                    break;
                case "MERGE":
                    mergeCell(word);
                    break;
                case "UNMERGE":
                    unmergeCell(word);
                    break;
                case "PRINT":
                    printCell(word);
                    break;
            }
        }
        return answer;
    }
    public void updateCell(String[] word){
        int r = Integer.parseInt(word[1]);
        int c = Integer.parseInt(word[2]);
        int idx = (r-1)*50+c;
        int root = find(idx);
        
        value[root] = word[3];
    }
    public void updateValue(String from, String to){
        for(int i=1; i<=2500; i++){
            if(value[i]!=null && value[i].equals(from)){
                value[i] = to;
            }
        }
    }
    public void mergeCell(String[] word){
        int r1 = Integer.parseInt(word[1]);
        int c1 = Integer.parseInt(word[2]);
        int r2 = Integer.parseInt(word[3]);
        int c2 = Integer.parseInt(word[4]);
        
        int a = (r1-1)*50+c1;
        int b = (r2-1)*50+c2;
        
        int pa = find(a);
        int pb = find(b);
        if(pa==pb) return;
        
        String v = (value[pa]!=null? value[pa]:value[pb]);
        
        union(pa,pb);
        int root = find(pa);
        value[root] = v;
    }
    public void unmergeCell(String[] word){
        int r = Integer.parseInt(word[1]);
        int c = Integer.parseInt(word[2]);
        int idx = (r-1)*50+c;
        
        int root = find(idx);
        String keep = value[root];
        
        List<Integer> toUnmerge = new ArrayList<>();
        for(int i=1; i<=2500; i++){
            if(find(i)==root) toUnmerge.add(i);
        }
        for(int i : toUnmerge){
            parent[i] = i;
            value[i] = null;
        }
        
        value[idx] = keep;
    }
    public void printCell(String[] word){
        int r = Integer.parseInt(word[1]);
        int c = Integer.parseInt(word[2]);
        int idx = (r-1)*50+c;
        int root = find(idx);
        
        answer.add(value[root]==null?"EMPTY": value[root]);
    }
    public void union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);
        if(p1!=p2){
            parent[p2] = p1;
        }
    } 
    public int find(int x){ 
        if(parent[x]!=x){
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}