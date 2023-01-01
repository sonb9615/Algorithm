package 위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_2252 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        adj = new ArrayList[n+1];
        indeg = new int[n+1];
        for(int i = 0; i < n+1; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(indeg[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            sb.append(x).append(' ');
            for(int node : adj[x]){
                --indeg[node];
                if(indeg[node] == 0) queue.add(node);
            }
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
