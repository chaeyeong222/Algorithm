class Solution { 
    public int solution(int storey) { 
        int answer = 0;
        while(storey > 0 ){
            int copy = storey%10;
            if(copy==5){
                int temp =  (storey/10)%10;
                if(temp>=5) { 
                    storey=storey/10+1; 
                }else{
                    storey=storey/10; 
                } 
                answer += copy;
            }else if(copy>=6){
                answer+=(10-copy);
                storey=storey/10+1;
            }else{
                answer += copy;
                storey=storey/10;
            }
        }
       return answer; 
    }//
}