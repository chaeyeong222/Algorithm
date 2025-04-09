import java.util.*;
import java.io.*;

class Solution {
    static int[][] users;
    static int[] emoticons;
    static int[] rate={10,20,30,40};
    static int n; 
    static int maxJoin = 0;
    static int maxSales = 0;
    public int[] solution(int[][] users, int[] emoticons) { 
        this.users = users;
        this.emoticons = emoticons;  
        n = emoticons.length;
        dfs(0, new int[n]); 
        return new int[]{maxJoin, maxSales};
    }
    private void dfs(int depth, int[] discountrates){
        if(depth==n){
            simulate(discountrates);
            return;
        }
        for(int discount : rate){
            discountrates[depth] = discount;
            dfs(depth+1, discountrates);
        }
    }
    private void simulate(int[] discountrates){
        int cnt = 0;
        int salesPrice = 0;
        for(int[] user : users){
            int disRate = user[0];
            int limitPrice = user[1];
            int sum = 0;
            for(int i=0; i<n; i++){
                if(discountrates[i] >= disRate){
                    sum += emoticons[i] * (100 - discountrates[i]) / 100;
                }
            }
            if(sum >= limitPrice){
                cnt++;
            }else{
                salesPrice+=sum;
            }
        }
        
        if(cnt > maxJoin || (cnt==maxJoin && salesPrice > maxSales)){
            maxJoin = cnt;
            maxSales = salesPrice;
        } 
        
    }
}