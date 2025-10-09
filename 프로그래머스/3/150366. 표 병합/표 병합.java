import java.util.*;
import java.io.*;
class Solution {
    public int[] parent;
    public String[] parentValue;
    List<String> list;
    public List<String> solution(String[] commands) {
        list = new ArrayList<>();//답 세팅
        //자기 자신으로 채워주기
        parent = new int[2501];
        parentValue=new String[2501]; //해당하는 값
        for(int i=1; i<=50; i++){
            for(int j=1; j<=50; j++){
                parent[(i-1)*50+j] = (i-1)*50+j;
            }
        }
        //명령어실행
        for(int i=0; i<commands.length; i++){
            String[] word = commands[i].split(" ");
            if(word[0].equals("UPDATE")){
                if(word.length==4){ //1번해당
                    int r = Integer.parseInt(word[1]);
                    int c = Integer.parseInt(word[2]);
                    int idx = (r-1)*50+c;
                    int root = find(idx);
                    
                    parentValue[root]=word[3];
                    for(int t=1; t<=2500; t++){
                        if(find(t)==root) parentValue[t] = word[3];
                    }
                }else{//2번해당 
                    for(int k=0; k<parentValue.length; k++){
                        if(parentValue[k] != null && parentValue[k].equals(word[1])){
                            parentValue[k]=word[2];
                        }
                    }
                }
            }else if(word[0].equals("MERGE")){
                int r1 = Integer.parseInt(word[1]);
                int c1 = Integer.parseInt(word[2]);
                int r2 = Integer.parseInt(word[3]);
                int c2 = Integer.parseInt(word[4]); 
                
                int a = (r1-1)*50+c1;
                int b = (r2-1)*50+c2;
                
                int pa = find(a);
                int pb = find(b);
                if(pa==pb) continue; //부모가 같다면 continue;
                
                String v1 = parentValue[pa];
                String v2 = parentValue[pb];
                
                union(pa,pb);//병합
                int root = find(pa);//루트노드 
                
                if(v1!=null){
                    parentValue[root] = v1;
                }else if(v2 !=null){
                    parentValue[root] = v2;
                }else{
                    parentValue[root] = null;
                }
                
                // 병합된 셀 전체 값 통일
                for (int t = 1; t <= 2500; t++) {
                     if (find(t) == root) parentValue[t] = parentValue[root];
                }
                
                //나머지 병합제거?
                if(root!=pa) parentValue[pa] = null;
                if(root!=pb) parentValue[pb] = null;
                
            }else if(word[0].equals("UNMERGE")){
                int r = Integer.parseInt(word[1]);
                int c = Integer.parseInt(word[2]);
                
                int idx = (r-1)*50+c; //부모찾아서 같은 부모인애들은 다 병합해제
                int parentIdx = find(idx);
                String keep = parentValue[parentIdx];//복원용
                
                for(int t=1; t<=2500; t++){
                    if(find(t)==parentIdx){
                        parent[t]=t;
                        parentValue[t] = null;
                    }
                }
                
                parentValue[idx] = keep;
            }else if(word[0].equals("PRINT")){
                int r = Integer.parseInt(word[1]);
                int c = Integer.parseInt(word[2]);
                
                int idx = (r-1)*50+c;
                int root = find(idx);
                if(parentValue[root]==null){
                    list.add("EMPTY");
                }else{
                   list.add(parentValue[root]); 
                }
                
            }
        } 
        
        return list;
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