package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_1389 {

    static FastReader scan = new FastReader();
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[][] visited;
    static int[] ans;

    static void pro(){
        input();
        dfs();
        int min =Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 1; i < N+1; i++){
            if(min > ans[i]){
                idx = i;
                min = ans[i];
            }
        }
        System.out.println(idx);
    }

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        ans = new int[N+1];
        visited = new int[N+1][N+1];
        adj = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++){
            adj[i] = new ArrayList<>();
            visited[i][i] = 0;
        }
        for(int i = 0; i < M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(){

        for(int i = 1; i < N+1; i++){
            int cnt = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()){
                int target = queue.poll();
                for(int x : adj[target]){
                    if(i == x || visited[i][x] > 0) continue;
                    ans[i] += visited[i][target] + 1;
                    visited[i][x] = visited[i][target]+1;
                    queue.add(x);
                }
            }
        }
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
