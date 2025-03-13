import java.io.*;
import java.util.*;

class Main {
    static int[] A, B;
    static int N, M;
    static List<Integer> list;
    public static void main(String[] args) throws Exception {
        set();
        pro();
        print();
    }
    public static void print(){
        if(list.size()==0) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(list);
            sb.append(list.size()).append('\n');
            for (int nn : list) {
                sb.append(nn).append(' ');
            }
            System.out.println(sb);
        }
    }
    public static void pro() {
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            if(!binarySearch(A[i])){
                list.add(A[i]);
            }
        }
    }
    public static boolean binarySearch(int target){
        int start = 0;
        int end = M-1;
        boolean flag = false;
        while(start<=end){
            int mid = (start+end)/2;
            if(B[mid]==target){
                flag = true;
                return flag;
            }else if( B[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return flag;

    }
    public static void set() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        A = new int[N];
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

    }
}
