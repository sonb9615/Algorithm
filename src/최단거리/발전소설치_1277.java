package 최단거리;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 발전소설치_1277 {

    static FastReader scan = new FastReader();
    static int n,w;
    static double m;
    static double[] dist;
    static boolean[][] connected;
    static class Edge{
        int x,y;
        public Edge(int _x, int _y){
            this.x = _x;
            this.y = _y;
        }
    }
    static Edge[] edges;

    static void input(){
        n = scan.nextInt();
        w = scan.nextInt();
        m = scan.nextDouble();
        edges = new Edge[n+1];
        dist = new double[n+1];
        for(int i = 1; i < n+1; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            edges[i] = new Edge(x,y);
        }
        connected = new boolean[n+1][n+1];
        for(int i = 0; i < w; i++){
            int from = scan.nextInt();
            int to = scan.nextInt();
            connected[from][to] = true;
            connected[to][from] = true;
        }
    }

    static void dijkstra(int start){

        for(int i = 1; i < n+1; i++) dist[i] = Double.MAX_VALUE;
        dist[start] = 0;
        for(int i = 2; i < n+1; i++){
            if(connected[1][i]) dist[i] = 0;
        }
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i < n; i++){
            double minDist = Double.MAX_VALUE;
            int cur = 0;
            for(int j = 1; j < n+1; j++){
                if(!visited[j] && minDist >= dist[j]){
                    minDist = dist[j];
                    cur = j;
                }
            }

            if(cur == n) break;
            visited[cur] = true;
            for(int j = 1; j < n+1; j++){
                if(j == cur) continue;
                int next = j;
                if(dist[next] > dist[cur] + getDistance(cur, next)){
                    dist[next] = dist[cur] + getDistance(cur, next);
                }
            }
        }
    }

    static double getDistance(int cur, int next){
        if(connected[cur][next]) return 0;
        Edge from = edges[cur];
        Edge to = edges[next];
        double rtn = Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2);
        return Math.sqrt(rtn);
    }

    static void pro(){
        dijkstra(1);
        System.out.println((long)(dist[n] * 1000));
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
