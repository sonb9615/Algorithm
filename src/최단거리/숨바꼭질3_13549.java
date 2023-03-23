package 최단거리;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    static FastReader scan = new FastReader();
    static int N,K;
    static int[] adj;

    static void pro(){
        N = scan.nextInt();
        K = scan.nextInt();
        adj = new int[100001];
        Arrays.fill(adj, Integer.MAX_VALUE);
        dijkstra();
        System.out.println(adj[K]);
    }

    static void dijkstra(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        adj[N] = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            if(check(x+1, x, 1)){
                queue.add(x+1);
                adj[x+1] = adj[x] + 1;
            }
            if(check(x-1, x, 1)){
                queue.add(x-1);
                adj[x-1] = adj[x] + 1;
            }
            if(check(x*2, x, 0)){
                queue.add(x*2);
                adj[x*2] = adj[x];
            }
        }
    }

    static boolean check(int newX, int x, int val){
        if(newX < 0 || newX > 100000) return false;
        if(adj[newX] > adj[x] + val) return true;
        return false;
    }

    public static void main(String[] args) {
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
