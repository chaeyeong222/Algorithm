import java.io.*;
import java.util.*;
//##22233
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String keyword = br.readLine();
            map.put(keyword, 0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(",");
            for (int j = 0; j < temp.length; j++) {
                if(map.containsKey(temp[j])){
                    map.remove(temp[j]);
                }

            }
            sb.append(map.size()).append('\n');
        }
        System.out.println(sb);

    }
}