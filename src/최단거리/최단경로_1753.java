package 최단거리;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {

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

    static int v,e,start;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void input(){
        v = scan.nextInt();
        e = scan.nextInt();
        start = scan.nextInt();
        edges = new ArrayList[v+1];
        dist = new int[v+1];
        for(int i = 1; i < v+1; i++) edges[i] = new ArrayList<>();
        for(int i = 0; i < e; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            edges[from].add(new Edge(to,cost));
        }
    }

    static void dijkstra(int start){
        for(int i = 1; i < v+1; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;

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
        for(int i = 1; i < v+1; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
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
