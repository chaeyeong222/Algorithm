import java.util.*;
import java.io.*;
class Solution {
    static long answer;
    static int dIdx;
    static int pIdx;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        answer = 0;
        dIdx = n-1;
        pIdx = n-1;
        while(dIdx>=0 || pIdx>=0){ 
            goCnt(cap, deliveries, pickups);
        } 
        return answer;
    }
    public void goCnt(int cap, int[] deliveries, int[] pickups) {
        while(dIdx>=0 && deliveries[dIdx]==0){
            dIdx--;
        }
        while(pIdx>=0 && pickups[pIdx]==0){
            pIdx--;
        } 
        if(dIdx>-1 && dIdx>=pIdx) {answer+=((dIdx+1)*2);}
        else if(pIdx>-1 && dIdx<pIdx){answer+=((pIdx+1)*2);}
        
        
        int dCap = cap;
        while(dIdx>=0 && dCap>0){//인덱스가 범위내에 있고, 수거상자 남아있으면
            //뒤에서부터 제거
            if(deliveries[dIdx]==0) {
                dIdx--; //앞으로 이동
            }else if(deliveries[dIdx]>=dCap){ //인덱스의 값이 cap보다 크거나 같으면
                deliveries[dIdx] -= dCap; //cap만큼 빼주고
                dCap = 0; 
                break;
            }else{
                dCap-=deliveries[dIdx]; //cap 줄여주고
                deliveries[dIdx]=0;
                dIdx--; //인덱스 이동
            }
        }
        
        int pCap = cap;
        while(pIdx>=0 && pCap>0){
            if(pickups[pIdx]==0) {
                pIdx--;
            }else if(pickups[pIdx]>=pCap){ //인덱스의 값이 cap보다 크거나 같으면
                pickups[pIdx] -= pCap; //cap만큼 빼주고
                pCap = 0;
                break;
            }else{
                pCap-=pickups[pIdx]; //cap 줄여주고
                pickups[pIdx]=0;
                pIdx--; //인덱스 이동
            }
        }
    }
}