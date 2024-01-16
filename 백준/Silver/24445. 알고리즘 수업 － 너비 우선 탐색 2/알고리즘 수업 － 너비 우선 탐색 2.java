import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num1 =  Integer.parseInt(st.nextToken());
            int num2 =  Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        
        for(int i=0; i<list.length; i++){
            Collections.sort(list[i], new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return o2-o1;
                }
            } );
        }
        
        //방문체크이자 순서로 활용할 int 배열
        int[] visited = new int[n+1]; 
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(r); 
        int turn = 1;
        visited[r] = turn++;
        
        
        
        while(!que.isEmpty()){
            int check = que.poll();
            for(int aa : list[check]){
                if(visited[aa]==0){
                    visited[aa] = turn++;
                    que.offer(aa);
                }
            }//  
        }
        
        for(int i=1; i<visited.length; i++){
            System.out.println(visited[i]);
        }
          
        
    }
    
}