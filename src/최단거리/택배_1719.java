package 최단거리;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배_1719 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static class Edge{
        int to, dist;
        public Edge(int _to, int _dist){
            this.to = _to;
            this.dist = _dist;
        }
    }

    static class Info{
        int idx, weight;
        public Info(int _idx, int _weight){
            this.idx = _idx;
            this.weight = _weight;
        }
    }

    static ArrayList<Edge>[] edges;
    static int n,m;
    static int[] dist;
    static int[][] ans;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        dist = new int[n+1];
        ans = new int[n+1][n+1];
        edges = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) edges[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dist = scan.nextInt();
            edges[x].add(new Edge(y,dist));
            edges[y].add(new Edge(x,dist));
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt( o -> o.weight));
        for(int i = 1; i < n+1; i++) dist[i] = Integer.MAX_VALUE;
        pq.add(new Info(start,0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(info.weight != dist[info.idx]) continue;
            for(Edge e : edges[info.idx]){
                if(dist[e.to] > e.dist + dist[info.idx]){
                    dist[e.to] = e.dist + dist[info.idx];
                    pq.add(new Info(e.to, dist[e.to]));
                    ans[e.to][info.idx] = e.to;
                }
            }
        }
    }

    static void pro(){
        for(int i = 1; i < n+1; i++){
            dijkstra(i);
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(i == j) sb.append("-").append(" ");
                else sb.append(ans[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
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
