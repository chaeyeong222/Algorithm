
import java.io.*;
import java.util.*;
//## 1595 북쪽나라의 도로
class Main {
    static int [] dist;
    static List<City>[] cities;
    static int maxDist, maxDIdx ;
    public static void main(String[] args) throws Exception {
        set();
        pro();
    }
    public static void pro(){
        dfs(1);

        dfs(maxDIdx);

        System.out.println(maxDist);

    }
    public static void dfs(int start){ 
        dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>(new Comparator<City>(){
            @Override
            public int compare(City o1, City o2){
                return o1.distance-o2.distance;
            }
        });

        pq.offer(new City(start,0));
        while(!pq.isEmpty()){
            City now = pq.poll();
            if(dist[now.index] < now.distance) continue;
            for(City next : cities[now.index]){
                if(dist[now.index] + next.distance < dist[next.index]){
                    dist[next.index] = dist[now.index] + next.distance;
                    pq.offer(new City(next.index, dist[next.index]));
                }
            }
        }

        maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if(dist[i]!=Integer.MAX_VALUE && dist[i] > maxDist){
                maxDist = dist[i];
                maxDIdx = i;
            }
        }

    }

    public static void set() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        cities = new ArrayList[10001];
        for (int i = 1; i < 10001; i++) {
            cities[i] = new ArrayList<>();
        } 
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            cities[num1].add(new City(num2, distance));
            cities[num2].add(new City(num1, distance));
        }
    }
}
class City{
    int index;
    int distance;
    City(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
}