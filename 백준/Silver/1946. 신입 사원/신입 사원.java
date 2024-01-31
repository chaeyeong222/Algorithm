import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int cnt = 1;
            int n = Integer.parseInt(br.readLine());
            Person[] persons = new Person[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int basic = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                Person p = new Person(basic, interview);
                persons[i] = p;
            }
            //면접순위별로 정렬
            Arrays.sort(persons, new Comparator<Person>(){
                @Override
                public int compare(Person p1, Person p2){
                    if(p2.paper<p1.paper) return 1;
                    else if(p2.paper==p1.paper) return 0;
                    else return -1;
                }
            });

            //이미 서류기준 정렬이 되어 있으므로, 다음인덱스의 서류 등수는 이전 인덱스의 서류 등수보다 낮음
            //따라서 현재 인덱스의 면접 등수는 그동안의 이전 인덱스들의 면접 등수보다 높아야 한다
            //for 돌면서 min 값을 갱신하고, 들고가면서 비교해야함.
            int min = persons[0].speech;
            for (int i = 1; i < n; i++) {
                if(persons[i].speech < min){
                    cnt++;
                    min = persons[i].speech;
                }
            }
            sb.append(cnt).append('\n');

        }//TC
        System.out.println(sb);

    }//main
}
class Person{
    int paper;
    int speech;

    public Person(int paper, int speech) {
        this.paper = paper;
        this.speech = speech;
    }
}
