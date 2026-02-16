import java.util.*;
import java.io.*;
class Solution {
    int[] arr;
    boolean[] visited;
    boolean flag = false;
    int[] dist, weak, doubleWeak;
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        this.dist = dist;
        this.weak = weak;
        int w = weak.length;
        doubleWeak = new int[w*2]; 
        for(int i=0; i<w; i++){
            doubleWeak[i] = weak[i];
            doubleWeak[i+w] = weak[i]+n;
        }
        int d = dist.length; //시도할 친구수
        for(int i=1; i<=d; i++){
            arr = new int[i];
            visited = new boolean[dist.length];
            find(0,i);
            if(flag){
                //청소 ㄱㄴ
                return i;
            }
        } 
        return -1;
    }
    public void find(int depth, int max){
        if(depth==max){
            //청소쳌
            clean();
            return;
        }
        for(int i=0; i<dist.length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                find(depth+1, max);
                visited[i] = false;
            } 
        } 
    }
    public void clean(){ 
        int w = weak.length;
        for(int start=0; start<w; start++){
            int cnt = 1;
            int position = doubleWeak[start] + dist[arr[0]];
            for(int i=start; i<start+w; i++ ){
                if(doubleWeak[i] > position){
                    cnt++;
                    if(cnt>arr.length){
                        break;
                    }
                    position = doubleWeak[i] + dist[arr[cnt-1]];
                }
                
            } 
            if(cnt <= arr.length){
                flag = true;
                return;
            }
        }
    }
}