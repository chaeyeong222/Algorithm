import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] denied; //여학생 별 퇴짜맞은 사람 번호
    static int[] pair; //짝꿍
    static List<Person>[] like;
    static int[] num = {6,7,8,9,10};
    static int[] arr = new int[5];
    static boolean[] visited = new boolean[5];
    static int pivot;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int TC = 0; TC < T; TC++) {
            flag = false;
            pair = new int[11];
            denied = new ArrayList[11];
            for (int i = 6; i <= 10; i++) {
                denied[i] = new ArrayList<>();
            }
            like = new ArrayList[11];
            for (int i = 1; i < 11; i++) {
                like[i] = new ArrayList<>();
            }

            // 남학생 2~5, 여학생 6~10 선호도 입력
            for (int i = 2; i <= 10; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    like[i].add(new Person(n, j));
                }
            }

            // 태현이 원래 선호도
            int r = 0;
            for (int i = 6; i <= 10; i++) {
                like[1].add(new Person(i, r++));
            }

            // pivot 구하기
            find();
            pivot = pair[1];

            // 태현이 선호도 조작해보기
            fixLike(0);

            if (flag) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    public static void fixLike(int depth) {
        if (depth == 5) {
            int r = 0;
            like[1] = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                like[1].add(new Person(arr[i], r++));
            }
            find();
            if (pair[1] < pivot) { // 번호 작으면 더 선호
                flag = true;
            }
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = num[i];
                fixLike(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void find() {
        Arrays.fill(pair, 0);
        for (int i = 6; i <= 10; i++) {
            denied[i].clear();
        }

        while (!allFindPair()) { // 수정된 부분
            for (int i = 6; i <= 10; i++) {
                if(pair[i]!=0) continue;
                for (Person next : like[i]) {
                    if (denied[i].contains(next.idx)) continue;
                    if (pair[next.idx] == 0) {
                        pair[next.idx] = i;
                        pair[i] = next.idx;
                        break;
                    } else {
                        int prev = pair[next.idx];
                        int prevR = 0, currR = 0;
                        for (Person p : like[next.idx]) {
                            if (p.idx == prev) prevR = p.rank;
                            if (p.idx == i) currR = p.rank;
                        }
                        if (prevR < currR) {
                            denied[i].add(next.idx);
                        } else {
                            denied[prev].add(next.idx);
                            pair[prev] = 0;
                            pair[next.idx] = i;
                            pair[i] = next.idx;

                        }
                        break;
                    }
                }
            }
        }
    }

    public static boolean allFindPair() {
        for (int i = 1; i <= 10; i++) {
            if (pair[i] == 0) return false;
        }
        return true;
    }
}

class Person {
    int rank;
    int idx;
    public Person(int idx, int rank) {
        this.idx = idx;
        this.rank = rank;
    }
}
