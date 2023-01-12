package 최단거리;

import java.io.*;
import java.util.*;

public class 서강그라운드_14938 {

    static FastReader scan = new FastReader();
    static int n,m,r;
    static int[] dist, itemCnt;
    static boolean[] visited;

    static class Edge{
        int to, dist;
        public Edge(int _to, int _dist){
            this.to = _to;
            this.dist = _dist;
        }
    }

    static ArrayList<Edge>[] edges;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        r = scan.nextInt();
        dist = new int[n+1];
        itemCnt = new int[n+1];
        edges = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            itemCnt[i] = scan.nextInt();
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i < r; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int len = scan.nextInt();
            edges[x].add(new Edge(y,len));
            edges[y].add(new Edge(x,len));
        }
    }

    static int dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        for(int i = 1; i < n+1; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        pq.add(new Edge(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int curIdx = edge.to;

            if(!visited[curIdx]){
                visited[curIdx] = true;
                for(Edge e : edges[curIdx]){
                    if(!visited[e.to] && dist[e.to] > dist[curIdx] + e.dist){
                        dist[e.to] = dist[curIdx] + e.dist;
                        pq.add(new Edge(e.to, dist[e.to]));
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 1; i < n+1; i++){
            if(dist[i] <= m) sum += itemCnt[i];
        }
        return sum;
    }

    static void pro(){
        int ans = 0;
        for(int i = 1; i < n+1; i++){
            ans = Math.max(ans, dijkstra(i));
        }
        System.out.println(ans);
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
