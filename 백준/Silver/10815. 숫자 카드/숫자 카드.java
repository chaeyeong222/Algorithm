import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.Arrays; 
import java.util.StringTokenizer;

public class Main {
    static int[] cards;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        cards = new int[N];
        //상근카드
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        //체크할 카드 수
        int M = Integer.parseInt(br.readLine());

        //카드 값
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num,0, cards.length-1)).append(' ');
        }
        System.out.println(sb);


    }
    public static int binarySearch(int key, int start, int end){
        int mid;
        while(start <= end){
            mid = (start+end)/2;
            if(key==cards[mid]) return 1;//찾음
            else if(key<cards[mid]){
                end = mid-1;
            }else if(key>cards[mid]){
                start = mid+1;
            }
        }
        return 0;

    }
}
