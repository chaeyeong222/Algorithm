import java.util.*;
import java.io.*;

class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>(); 
        PriorityQueue<Work> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Work o1, Work o2){
                return o1.start-o2.start;
            }
        }); 
        for(int i=0; i<plans.length; i++){
            String name = plans[i][0];
            String[] temp = plans[i][1].split(":");
            int h = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int startTime = h*60 + m;
            int time = Integer.parseInt(plans[i][2]);
            pq.add(new Work(name,startTime,time));
        }
        
        Stack<Work> stack = new Stack<>(); //잠시 멈춘 과제들
        while(!pq.isEmpty()){
            Work now = pq.poll();
            
            //현재시간
            int nowTime = now.start;
            
            if(!pq.isEmpty()){ //새로운 과제 있다면
                Work next = pq.peek(); 
                //지금것 끝내고도 시간이 남는다면
                if(nowTime + now.playtime < next.start){
                    answer.add(now.name); //끝난것에 지금거 추가
                    nowTime += now.playtime;
                    
                    //잠시 멈춘과제 있다면
                    while(!stack.isEmpty()){
                        Work temp = stack.pop();
                        //다음 것 시간전에 다 끝낼 수 있다면
                        if(nowTime + temp.playtime <= next.start){
                            nowTime += temp.playtime;
                            answer.add(temp.name);
                            continue;
                        }else{
                            //중간에 멈춰야 한다면
                            int tt = temp.playtime - (next.start - nowTime);
                            stack.push(new Work(temp.name, tt));
                            break;
                        }
                    }
                }
                
                else if(now.start + now.playtime == next.start){
                    //지금것 끝냈을때 바로 다음거 시작해야한다면 
                    answer.add(now.name);
                    continue;
                }else{
                    //중간에 멈춰야하는 경우
                    int tt = (next.start - nowTime);
                    stack.push(new Work(now.name, now.playtime-tt));
                } 
            }
            else{ //더이상 남은 과제 없을때
                if(stack.isEmpty()){
                    //멈춘과제도 없다면
                    nowTime += now.playtime;
                    answer.add(now.name);
                }else{
                    answer.add(now.name);
                    while(!stack.isEmpty()){
                        Work rem = stack.pop();
                        answer.add(rem.name);
                    }
                }
            } 
        } 
        return answer;
    }
}
class Work{
    String name;
    int start;
    int playtime;
    public Work(String name, int start, int playtime){
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
    public Work(String name , int playtime){
        this.name = name;
        this.playtime = playtime;
    }
}