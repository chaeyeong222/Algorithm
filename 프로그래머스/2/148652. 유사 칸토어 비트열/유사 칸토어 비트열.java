class Solution {
    long[] pow5;
    long[] ones;
    public long solution(int n, long l, long r) {
        pow5 = new long[n+1];
        ones = new long[n+1];
        pow5[0] = 1;
        ones[0] = 1;
        for(int i=1; i<=n; i++){
            pow5[i] = pow5[i-1]*5;
            ones[i] = ones[i-1]*4;
        } 
        long a = getOneCnt(n,r);
        long b = getOneCnt(n,l-1);
        return a-b;
    }
    public long getOneCnt(int n, long x){
        if(x<=0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        long blockSize = pow5[n-1];
        long block = (x-1)/blockSize;
        long remain = x%blockSize;
        if(remain==0) remain = blockSize;
        
        if(block==2){
            return 2*ones[n-1];
        }else if(block<2){
            return block * ones[n-1] + getOneCnt(n-1, remain);
        }else{
            return 2 * ones[n-1] + (block-3)*ones[n-1] + getOneCnt(n-1, remain);
        } 
    }
}
/**
1 > 1 
11011 > 4 
1101111011000001101111011 > 2 = 16
11011110110000011011110111101111011000001101111011
*/