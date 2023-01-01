package 위상정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        adj = new ArrayList[n+1];
        indeg = new int[n+1];
        for(int i = 0; i < n+1; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int cnt = scan.nextInt();
            int oldX = scan.nextInt();
            for(int j = 0; j < cnt-1; j++){
                int x = scan.nextInt();
                adj[oldX].add(x);
                oldX = x;
                ++indeg[x];
            }
        }
    }

    static void pro(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(indeg[i] == 0) queue.add(i);
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            ++cnt;
            int x = queue.poll();
            sb.append(x).append('\n');
            for(int idx : adj[x]){
                --indeg[idx];
                if(indeg[idx] == 0) queue.add(idx);
            }
        }
        if(cnt < n) System.out.println(0);
        else System.out.println(sb);
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
