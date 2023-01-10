package 최단거리;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기_1916 {

    static FastReader scan = new FastReader();

    static class Edge{
        public int to, weight;
        public Edge(int _to, int _weight){
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info{
        public int idx, dist;
        public Info(int _idx, int _dist){
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int n,m,start,end;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        dist = new int[n+1];
        edges = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) edges[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            edges[from].add(new Edge(to,cost));
        }
        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void dijkstra(int start){
        // 모든 값들 최대값으로 초기화
        for(int i = 1; i < n+1; i++) dist[i] = Integer.MAX_VALUE;
        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        // 시작점에 대한 정보(Info)를 기록에 추가하고, 거리 배열(dist)에 갱신
        pq.add(new Info(start, 0));
        dist[start] = 0;
        //거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(dist[info.idx] != info.dist) continue;
            for(Edge e : edges[info.idx]){
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }

    }

    static void pro(){
        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
