

import java.io.*;
import java.util.*;
//##
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); //정렬

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            //i는 현재 체크해야할 값
            int left = 0;
            int right = n-1;

            while(true){
                if(left==i){left++;}
                else if(right==i){right--;}

                if(left>=right)  break;

                if(num[left]+num[right]>num[i]){
                    right--;
                }else if(num[left]+num[right]<num[i]){
                    left++;
                }else{
                    cnt++;
                    break;
                }
            }
        }//for
        System.out.println(cnt);

    }

}