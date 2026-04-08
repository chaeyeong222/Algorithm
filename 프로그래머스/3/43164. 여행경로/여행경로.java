import java.util.*;
class Solution {
    int n; 
    boolean[] used;
    String[][] tickets;
    int[] arr;
    boolean flag = false;
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        this.tickets = tickets;
        used = new boolean[n];
        arr = new int[n]; 
        
        //티켓정렬
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });
        
        useTicket(0, "ICN");
        String[] answer = new String[n+1];
        answer[0] = "ICN";
        for(int i=0; i<n; i++){
            int idx = arr[i];
            String temp = tickets[idx][1]; 
            answer[i+1] = temp;
        }
        
        return answer;
    }
    public void useTicket(int depth, String airport){
        if(flag) return;
        if(depth>n) return;
        if(depth==n){
            flag = true;
            return;
        }
        for(int i=0; i<n; i++){
            if(tickets[i][0].equals(airport) && !used[i]){
                used[i] = true;
                arr[depth]=i;
                useTicket(depth+1, tickets[i][1]); 
                if(flag) return;
                used[i] = false;
            }
        }
    }
}