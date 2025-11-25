import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Main {
    static int N,C;
    static long[] num;
    static long[] leftnum;
    static long[] rightnum;
    static List<Long> leftSide = new ArrayList<>();
    static List<Long> rightSide = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }

    static void pro(){
        getList(leftSide, 0,0,leftnum);
        getList(rightSide, 0,0,rightnum);

        Collections.sort(rightSide);

        long count = 0;
        for(long l : leftSide){
            long rest = C - l;
            int idx = upperBound(rightSide, rest);
            count += idx;
        }
        System.out.println(count);

    }
    static int upperBound(List<Long> list , long rest){
        int left = 0;
        int right = list.size();
        while(left<right){
            int mid=(left+right)/2;
            if(list.get(mid) <= rest){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    static void getList(List<Long> list, int idx, long sum, long[] nums){
        if(sum>C) return;
        if(idx==nums.length){
            list.add(sum);
            return;
        }
        getList(list, idx+1, sum+nums[idx], nums);
        getList(list, idx+1, sum, nums);
    }
    static void set() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        num = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }
        int mid = N/2;
        leftnum = Arrays.copyOfRange(num, 0, mid);
        rightnum = Arrays.copyOfRange(num, mid, N);

    }
}