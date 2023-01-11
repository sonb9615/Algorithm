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
        
    }

    static void pro(){
        dijkstra(1);
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
